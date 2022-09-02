import org.junit.Test;
import util.JDBC;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 陈境聪
 * @date 2022年09月02日 10:19
 */

public class test {

    @Test
    public void test() {
        try {
            Connection connection = JDBC.getConnection();
            System.out.println(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
