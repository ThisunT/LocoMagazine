package UI.Index;




import java.sql.*;


/**
 * Created by acer on 10/9/2017.
 */
public class Connect {

        Connection conn=null;

        public static Connection ConnectDB(){
            try{

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","");
                System.out.println("success");
                return conn;


            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

