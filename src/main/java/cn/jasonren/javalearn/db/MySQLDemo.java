package cn.jasonren.javalearn.db;

import java.sql.*;

/**
 * @author zhicheng
 * @create 2018-07-20 下午2:55
 */


public class MySQLDemo {
    //JDBC 驱动名及数据库URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/seckill?useSSL=false";

    //数据库的用户名及密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "32147";

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            //注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            //打开链接
            System.out.println("连接数据库...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);


            //执行查询
            System.out.println("实例化Statement对象...");
            stmt = connection.createStatement();
            String sql;
            sql = "SELECT * FROM seckill";
            ResultSet rs = stmt.executeQuery(sql);

            //展开结果集
            while (rs.next()){
                //通过字段检索
                int seckill_id = rs.getInt("seckill_id");
                String name = rs.getString("name");

                //输出数据
                System.out.println("seckill_id:" + seckill_id);
                System.out.println("name:" + name);
            }

            //输出数据
            rs.close();
            stmt.close();
            connection.close();




        }catch (SQLException e){
            //处理JDBC错误
            e.printStackTrace();
        }catch (Exception e){
            //处理Class.forName错误
            e.printStackTrace();
        }finally {
            //关闭资源
            try{
                if(stmt != null) stmt.close();
            }catch (SQLException e){

            }
            try {
                if(connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
