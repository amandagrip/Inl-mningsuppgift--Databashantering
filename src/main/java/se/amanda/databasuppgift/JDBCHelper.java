package se.amanda.databasuppgift;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCHelper {
    private static Properties properties = new Properties();

    static{
        try{
            InputStream stream = JDBCHelper.class.getClassLoader().getResourceAsStream("application.properties");
            if (stream == null) {
                System.err.println("No application properties file");
            } else {
                properties.load(stream);
                System.out.println("Application properties loaded");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Driver driver = new org.hsqldb.jdbcDriver();
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(url, user, password);
        

    }
}
