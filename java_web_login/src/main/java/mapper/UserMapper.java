package mapper;

import model.User;
import util.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 陈境聪
 * @date 2022年09月02日 10:23
 */

public class UserMapper {

    public User getUserToLogin(String username,String password) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username = ? and password= ?";
        try {
            conn = JDBC.getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getObject(1,Integer.class));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                JDBC.close(conn,preparedStatement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
