package org.jdbc.sqlhelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import java.util.Date;


/**
 * 数据库链接池管理类
 *
 * @author Tom
 *
 */
public final class DBConnectionPool extends Pool {
	private int checkedOut; //正在使用的连接数
	/**
	 * 存放产生的连接对象容器
	 */
	private Vector<Connection> freeConnections = new Vector<Connection>(); //存放产生的连接对象容器

	private String passWord = null; // 密码

	private String url = null; // 连接字符串

	private String userName = null; // 用户名

	private static int num = 0;// 空闲连接数

	private static int numActive = 0;// 当前可用的连接数

	private static DBConnectionPool pool = null;// 连接池实例变量

	/**
	 * 产生数据连接池
	 * @return
	 */
	public static synchronized DBConnectionPool getInstance()
	{
		if(pool == null)
		{
			pool = new DBConnectionPool();
		}
		return pool;
	}

	/**
	 * 获得一个 数据库连接池的实例
	 */
	private DBConnectionPool() {
		try
		{
			init();
			for (int i = 0; i < normalConnect; i++) { // 初始normalConn个连接
				Connection c = newConnection();
				if (c != null) {
					freeConnections.addElement(c); //往容器中添加一个连接对象
					num++; //记录总连接数
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 初始化
	 * @throws IOException
	 *
	 */
	private void init() throws IOException
	{
		InputStream is = DBConnectionPool.class.getResourceAsStream(propertiesName);
		Properties p = new Properties();
		p.load(is);
		this.userName = p.getProperty("userName");
		this.passWord = p.getProperty("passWord");
		this.driverName = p.getProperty("driverName");
		this.url = p.getProperty("url");
		this.driverName = p.getProperty("driverName");
		this.maxConnect = Integer.parseInt(p.getProperty("maxConnect"));
		this.normalConnect = Integer.parseInt(p.getProperty("normalConnect"));
	}

	/**
	 * 如果不再使用某个连接对象时,可调此方法将该对象释放到连接池
	 *
	 * @param con
	 */
	public synchronized void freeConnection(Connection con) {
		freeConnections.addElement(con);
		num++;
		checkedOut--;
		numActive--;
		notifyAll(); //解锁
	}

	/**
	 * 创建一个新连接
	 *
	 * @return
	 */
	private Connection newConnection() {
		Connection con = null;
		try {
			if (userName == null) { // 用户,密码都为空
				con = DriverManager.getConnection(url);
			} else {
				con = DriverManager.getConnection(url, userName, passWord);
			}
			System.out.println("连接池创建一个新的连接");
		} catch (SQLException e) {
			System.out.println("无法创建这个URL的连接" + url);
			return null;
		}
		return con;
	}

	/**
	 * 返回当前空闲连接数
	 *
	 * @return
	 */
	public int getnum() {
		return num;
	}

	/**
	 * 返回当前连接数
	 *
	 * @return
	 */
	public int getnumActive() {
		return numActive;
	}

	/**
	 * (单例模式)获取一个可用连接
	 *
	 * @return
	 */
	public synchronized Connection getConnection() {
		Connection con = null;
		if (freeConnections.size() > 0) { // 还有空闲的连接
			num--;
			con = (Connection) freeConnections.firstElement();
			freeConnections.removeElementAt(0);
			try {
				if (con.isClosed()) {
					System.out.println("从连接池删除一个无效连接");
					con = getConnection();
				}
			} catch (SQLException e) {
				System.out.println("从连接池删除一个无效连接");
				con = getConnection();
			}
		} else if (maxConnect == 0 || checkedOut < maxConnect) { // 没有空闲连接且当前连接小于最大允许值,最大值为0则不限制
			con = newConnection();
		}
		if (con != null) { // 当前连接数加1
			checkedOut++;
		}
		numActive++;
		return con;
	}

	/**
	 * 获取一个连接,并加上等待时间限制,时间为毫秒
	 *
	 * @param timeout  接受等待时间(以毫秒为单位)
	 * @return
	 */
	public synchronized Connection getConnection(long timeout) {
		long startTime = new Date().getTime();
		Connection con;
		while ((con = getConnection()) == null) {
			try {
				wait(timeout); //线程等待
			} catch (InterruptedException e) {
			}
			if ((new Date().getTime() - startTime) >= timeout) {
				return null; // 如果超时,则返回
			}
		}
		return con;
	}

	/**
	 * 关闭所有连接
	 */
	public synchronized void release() {
		try {
			//将当前连接赋值到 枚举中
			Enumeration allConnections = freeConnections.elements();
			//使用循环关闭所用连接
			while (allConnections.hasMoreElements()) {
				//如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素
				Connection con = (Connection) allConnections.nextElement();
				try {
					con.close();
					num--;
				} catch (SQLException e) {
					System.out.println("无法关闭连接池中的连接");
				}
			}
			freeConnections.removeAllElements();
			numActive = 0;
		} finally {
			super.release();
		}
	}

	/**
	 * 建立连接池
	 */
	public void createPool() {

		pool = new DBConnectionPool();
		if (pool != null) {
			System.out.println("创建连接池成功");
		} else {
			System.out.println("创建连接池失败");
		}
	}
}
