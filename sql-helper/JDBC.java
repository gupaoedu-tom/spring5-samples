public void save(Student stu){
    String sql="INSERT INTO t_student(name,age) VALUES(?,?)";
    Connection conn=null;
    Statement st=null;
    try{
        // 1. 加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取数据库连接
        conn=DriverManager.getConnection("jdbc:mysql:///jdbcdemo","root","root");
        // 3. 创建语句对象
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setObject(1,stu.getName());
        ps.setObject(2,stu.getAge());
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(st!=null)
                st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

// 删除学生信息
public void delete(Long id){
    String sql="DELETE  FROM t_student WHERE id=?";
    Connection conn=null;
    Statement st=null;
    try{
        // 1. 加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取数据库连接
        conn=DriverManager.getConnection("jdbc:mysql:///jdbcdemo","root","root");
        // 3. 创建语句对象
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setObject(1,id);
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(st!=null)
                st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}

// 修改学生信息
public void update(Student stu){
    String sql="UPDATE t_student SET name=?,age=? WHERE id=?";
    Connection conn=null;
    Statement st=null;
    try{
        // 1. 加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 获取数据库连接
        conn=DriverManager.getConnection("jdbc:mysql:///jdbcdemo","root","root");
        // 3. 创建语句对象
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setObject(1,stu.getName());
        ps.setObject(2,stu.getAge());
        ps.setObject(3,stu.getId());
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try{
            if(st!=null)
                st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}




//工具类
public class JdbcUtil {
    private JdbcUtil() { }
    static {
        //	1. 加载注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            // 2. 获取数据库连接
            return DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}




// 增加学生信息
public void save(Student stu) {
    String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
    Connection conn = null;
    PreparedStatement ps=null;
    try {
        conn = JDBCUtil.getConnection();
        // 3. 创建语句对象
        ps = conn.prepareStatement(sql);
        ps.setObject(1, stu.getName());
        ps.setObject(2, stu.getAge());
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(null, ps, conn);
    }

}

// 删除学生信息
public void delete(Long id) {
    String sql = "DELETE  FROM t_student WHERE id=?";
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn=JDBCUtil.getConnection();
        // 3. 创建语句对象
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(null, ps, conn);
    }

}

// 修改学生信息
public void update(Student stu) {
    String sql = "UPDATE t_student SET name=?,age=? WHERE id=?";
    Connection conn = null;
    PreparedStatement ps = null;
    try {
        conn=JDBCUtil.getConnection();
        // 3. 创建语句对象
        ps = conn.prepareStatement(sql);
        ps.setObject(1, stu.getName());
        ps.setObject(2, stu.getAge());
        ps.setObject(3, stu.getId());
        // 4. 执行SQL语句
        ps.executeUpdate();
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(null, ps, conn);
    }

}

public Student get(Long id) {
    String sql = "SELECT * FROM t_student WHERE id=?";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
    try {
        conn = JDBCUtil.getConnection();
        // 3. 创建语句对象
        ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        // 4. 执行SQL语句
        rs = ps.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu = new Student(id, name, age);
            return stu;
        }
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(rs, ps, conn);
    }
    return null;
}

public List<Student> list() {
    List<Student> list = new ArrayList<>();
    String sql = "SELECT * FROM t_student ";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement ps=null;
    try {
        conn=JDBCUtil.getConnection();
        // 3. 创建语句对象
        ps = conn.prepareStatement(sql);
        // 4. 执行SQL语句
        rs = ps.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu = new Student(id, name, age);
            list.add(stu);
        }
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(rs, ps, conn);
    }
    return list;
}



static {
    // 1. 加载注册驱动
    try {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = loader.getResourceAsStream("db.properties");
        p = new Properties();
        p.load(inputStream);
        Class.forName(p.getProperty("driverClassName"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static Connection getConnection() {
    try {
        // 2. 获取数据库连接
        return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
        p.getProperty("password"));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}


//查询统一模板
public static List<Student> query(String sql,Object...params){
    List<Student> list=new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    try {
        conn=JDBCUtil.getConnection();
        ps=conn.prepareStatement(sql);
        //设置值
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        rs = ps.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu = new Student(id, name, age);
            list.add(stu);
        }
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JDBCUtil.close(rs, ps, conn);
    }
    return list;
}



// 增加学生信息
public void save(Student stu) {
    String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
    Object[] params=new Object[]{stu.getName(),stu.getAge()};
    JdbcTemplate.update(sql, params);
}

// 删除学生信息
public void delete(Long id) {
    String sql = "DELETE FROM t_student WHERE id = ?";
    JdbcTemplate.update(sql, id);
}

// 修改学生信息
public void update(Student stu) {
    String sql = "UPDATE t_student SET name = ?,age = ? WHERE id = ?";
    Object[] params=new Object[]{stu.getName(),stu.getAge(),stu.getId()};
    JdbcTemplate.update(sql, params);
}

public Student get(Long id) {
    String sql = "SELECT * FROM t_student WHERE id=?";
    List<Student> list = JDBCTemplate.query(sql, id);
    return list.size()>0? list.get(0):null;
}

public List<Student> list() {
    String sql = "SELECT * FROM t_student ";
    return JDBCTemplate.query(sql);
}



public interface IRowMapper {
    //处理结果集
    List rowMapper(ResultSet rs) throws Exception;
}



public static List<Student> query(String sql,IRowMapper rsh, Object...params){
    List<Student> list = new ArrayList<>();
    Connection conn = null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    try {
        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement(sql);
        //设置值
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        rs = ps.executeQuery();
        return rsh.mapping(rs);
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JdbcUtil.close(rs, ps, conn);
    }
    return list ;
}



public Student get(Long id) {
    String sql = "SELECT * FROM t_student WHERE id = ?";
    List<Student> list = JdbcTemplate.query(sql,new StudentRowMapper(), id);
    return list.size()>0? list.get(0):null;
}
public List<Student> list() {
    String sql = "SELECT * FROM t_student ";
    return JdbcTemplate.query(sql,new StudentRowMapper());
}
class StudentRowMapper implements IRowMapper{
    public List mapping(ResultSet rs) throws Exception {
        List<Student> list=new ArrayList<>();
        while(rs.next()){
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu=new Student(id, name, age);
            list.add(stu);
        }
        return list;
    }
}




public static <T> T query(String sql,IRowMapper<T> rsh, Object...params){
    Connection conn = null;
    PreparedStatement ps=null;
    ResultSet rs = null;
    try {
        conn = JdbcUtil.getConnection();
        ps = conn.prepareStatement(sql);
        //设置值
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        rs = ps.executeQuery();
        return rsh.mapping(rs);
        // 5. 释放资源
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        JdbcUtil.close(rs, ps, conn);
    }
    return null;
}


class StudentRowMapper implements IRowMapper<List<Student>>{
    public List<Student> mapping(ResultSet rs) throws Exception {
        List<Student> list=new ArrayList<>();
        while(rs.next()){
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu=new Student(id, name, age);
            list.add(stu);
        }
        return list;
    }
}


public Long getCount(){
    String sql = "SELECT COUNT(*) total FROM t_student";
    Long totalCount = (Long) JdbcTemplate.query(sql,
            new IRowMapper<Long>() {
                public Long mapping(ResultSet rs) throws Exception {
                    Long totalCount = null;
                    if(rs.next()){
                        totalCount = rs.getLong("total");
                    }
                    return totalCount;
                }
            });
    return totalCount;
}