package Homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 这里有什么问题？
 * 1.配置写死在了代码里面。不灵活。  把它抽到配置文件里面去。
 * 2.Driver类，直接依赖了mysql的jar。  依赖太强了。  用反射来解决。
 * <p>
 * <p>
 * 扩展： 反射是干什么的？
 *
 * @author Common-zhou
 * @since 2023-11-30 09:41
 */
public class JdbcUtil {

    private static String url;
    private static String username;
    private static String password;
    private static String driverClassName;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
        driverClassName = properties.getProperty("driverClassName");
    }


    // 写一个方法，用来获取连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // 1. 加载驱动
//         DriverManager.registerDriver(new Driver());

        // 只要我将 mysql的 Driver类加载进来。 就会自动执行static代码块。驱动就会自动注册完成。
        Class.forName(driverClassName);

        // 2. 获取连接
        return DriverManager.getConnection(url, username, password);
    }

    // 写一个方法，用来释放资源
    public static void release(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

}
