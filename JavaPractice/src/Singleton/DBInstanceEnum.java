
package Singleton;
import java.sql.*;

public enum DBInstanceEnum {
    INSTANCE;
    private Connection connection;

    DBInstanceEnum(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/yourDatabase", // URL
                    "yourUsername",                            // Username
                    "yourPassword"                             // Password
            );
            System.out.println("Database connection established.");
        } catch (ClassNotFoundException | SQLException exception){
            exception.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", exception);
        }
    }

    public Connection getConnection(){
        return DBInstanceEnum.INSTANCE.getConnection();
    }
}
