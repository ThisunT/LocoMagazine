package UI.Foreman.Failure;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by piumiindeevari on 10/7/2017.
 */
public class FailureController implements Initializable {
    public Button submitButton;
    public Button test;
    public ComboBox<String> failureTypeCombo;


    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    List<String> failureTypes = new ArrayList<>();

    public FailureController(){
        conn=Connect.ConnectDB();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String sql = "SELECT * FROM failure";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString("Failure_Type"));
                failureTypes.add(rs.getString("Failure_Type"));
                failureTypeCombo.setItems(FXCollections.observableArrayList(failureTypes));
            }
        } catch (SQLException e) {
            System.out.println("AIYOO");

        }

    }


     public void pressSubmit(ActionEvent event)throws Exception {

        /*
         String sql = "SELECT * FROM failure";

         try{
             ps= conn.prepareStatement(sql);
             rs= ps.executeQuery(sql);

            while (rs.next()) {
                //System.out.println(rs.getString("Failure_Type"));
                failureTypes.add(rs.getString("Failure_Type"));
                failureTypeCombo.setItems(FXCollections.observableArrayList(failureTypes));
            }
        }
        catch (SQLException e){
            System.out.println("AIYOO");

            }
            */
    }



}
