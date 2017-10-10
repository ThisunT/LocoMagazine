package UI.Foreman.Failure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by piumiindeevari on 10/6/2017.
 */
public class Connect {
    public static Connection conn=null;



    public Connect() {
    }


    public static Connection ConnectDB(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
            System.out.println("success");
            return conn;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}