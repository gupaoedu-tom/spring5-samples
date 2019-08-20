package org.jdbc.sqlhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据库操作类
 * 包含两个构造函数 <br/>
 * <b><font color="red">DataBaseCmd()</font></b> 使用自定义连接池获得连接<br/>
 * <b><font color="red">DataBaseCmd(String datasource)</font></b> 指定 JNDI 的数据源名称
 * @author tanyongde
 * 
 */
public class DataBaseCmd {
	
	private PreparedStatement pstmt = null;// 连接语句
	private Connection con = null;// 获取连接对象
	private ResultSet rs = null;
	private String datasource = null; //指定使用的数据源
	/**
	 * 默认构造器
	 *
	 */
	public DataBaseCmd()
	{
		
	}
	/**
	 * 构造器
	 * @param datasource 指定使用的JNDI查找的数据源名称
	 * 	Tomcat 的数据源名为 java:comp/env/test
	 */
	public DataBaseCmd(String datasource)
	{
		this.datasource = datasource;
	}
	 /**
	    * 初始化数据库连接对象
	    */
	   private synchronized void initCon()
	   {
		   try {
			   if(null == con)
			   {
				   if(null == datasource || "".equals(datasource))
				   {
					   con = ConManager.getConnection();
				   }else
				   {
					   con = ConManager.getConnection(datasource);
				   }
			   }
		   } catch (Exception e) {
			   e.printStackTrace();
		   }
	   }
	
	 /**
	  * 查询表格数据,此方法一般将单表中所有的数据查询出来，如果需要匹配条件查询，则最好在业务逻辑层或者界面层做数据解析或者在查询语句中直接带条件
	  * @param sql 要执行的sql语句或者存储过程的名称
	  * @param cmdtype 指定sql参数的类型：true为存储过程，false为sql语句
	  * @param values 指定sql语句中的参数列表
	  * @return 返回更新后的结果集
	  * @throws Exception
	  */
	 public ResultSet excuteQuery(String sql, boolean cmdtype,List values)throws Exception
	 {
		 try
		 {
			 initCon();
			 //储存过程处理
			 if(cmdtype)
			 {
				 pstmt = con.prepareCall(sql);  //处理存储过程的语句集
			 }else
			 {
				 pstmt = con.prepareStatement(sql);
			 }
			 if(values != null && values.size() >0)
			 {
				 setValues(pstmt,values);
			 }
			rs = pstmt.executeQuery();
			return rs;
		 }catch(Exception ex)
		 {
				throw ex; 
		 }
	 }
	
	 /**
	  *  实现对数据的的增／删／改 
	  * @param sql 要执行的sql语句或者存储过程的名称
	  * @param cmdtype 指定sql参数的类型：true为存储过程，false为sql语句
	  * @param values 存储过程或者sql语句中要指定的参数列表，无则为null
	  * @return true执行成功，false执行失败
	  * @throws Exception
	  */
	 public int excuteUpdate(String sql,boolean cmdtype,List values)throws Exception
	 {
		 int noOfRows = 0;
		 try
		 {
			 initCon();
			 if(cmdtype)
			 {
				 pstmt = con.prepareCall(sql);  //处理存储过程的语句集
			 }else
			 {
				 pstmt = con.prepareStatement(sql);
			 }
			 if(values != null && values.size() >0)
			 {
				 setValues(pstmt,values);
			 }
			 noOfRows = pstmt.executeUpdate();
		 }catch(Exception ex)
		 {
			throw ex; 
		 }
		 return noOfRows; 
	 }
	 

	/**
	 * 关闭连接
	 */
	public void closeConnection() {
		try {
			if (null != con && !con.isClosed()) {

				ConManager.closeCon(con);
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭语句集
	 */
	public void closePstmt() {
		if (null != pstmt) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * 关闭结果集
	 */
	public void closeResultSet() {
		if (null != rs) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	/**
	 * 关闭所有数据库访问对象
	 *
	 */
	public void closeAll()
	{
		closePstmt();
		closeResultSet();
		closeConnection();
	}
	 
	 /**
	  * 设定语句 得参数
	  * @param pstmt 语句集 对象
	  * @param values 指定 sql 语句中的参数列表
	  * @throws SQLException
	  */
	 private void setValues(PreparedStatement pstmt,List values)throws SQLException
	 {
		 for(int i=0;i<values.size();i++)
		 {
			 Object v = values.get(i);
			 pstmt.setObject(i+1, v);
		 }
	 }
	 
	 /**
	  * (不建议使用的方法)使用 JNDI 的方式获取数据源时应使用此方法
	  * 建议在构造器中直接传递参数
	  * @param datasource 数据库连接使用的数据源名称
	  * @deprecated
	  */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
}
