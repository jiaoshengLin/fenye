package com.qf.utils;

import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtils {
    public static String driver ;
    public static String url ;
    public static String user ;
    public static String password ;

    static {
        try {
            Properties properties = new Properties();
            properties.load(DBUtils.class.getResourceAsStream("/db.properties"));
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
            // 注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回Connection对象
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭connection连接
     */
    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭PreparedStatement
     */
    public static void closePreparedStatement(PreparedStatement ps){
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭ResultSet
     */
    public static void closeResultSet(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 统一关闭资源
     */
    public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
        closeResultSet(rs);
        closePreparedStatement(ps);
        closeConnection(conn);
    }



}
