package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 陈境聪
 * @date 2022年09月02日 10:14
 */

public class JDBC {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，加载就初始化
    static {
        Properties properties = new Properties();
        //读取db.properties内容
        InputStream is = JDBC.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //获取数据库的链接
        Connection connection=null;
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    //释放资源
    public static boolean close(Connection connection, PreparedStatement preparedStatement, ResultSet rs) throws SQLException {
        boolean flag=true;
        if (rs!=null){
            rs.close();
            //GC回收
            rs=null;
        }else {
            flag=false;
        }
        if (connection!=null){
            connection.close();
            //GC回收
            connection=null;
        }else {
            flag=false;
        }
        if (preparedStatement!=null){
            preparedStatement.close();
            //GC回收
            preparedStatement=null;
        }else {
            flag=false;
        }
        return flag;
    }
}
