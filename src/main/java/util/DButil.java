package util;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DButil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop1 = new Properties();
                File myfile = new File("src/main/resources/db.properties");
                FileInputStream propertiesInputStream = new FileInputStream(myfile);
                prop1.load(propertiesInputStream);
                String driver = prop1.getProperty("driver");
                String url = prop1.getProperty("url");
                String user = prop1.getProperty("user");
                String password = prop1.getProperty("password");

                Class.forName(driver);

                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }

}
