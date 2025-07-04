package main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;

public class DBUtil {
    public static Connection getConnection() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/properties/db.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
