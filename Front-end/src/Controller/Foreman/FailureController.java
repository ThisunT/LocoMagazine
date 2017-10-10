package Controller.Foreman;

import Model.Connect;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by piumiindeevari on 10/10/2017.
 */
public class FailureController implements Initializable {
    List<String> listCombo = new ArrayList<>();

    public ComboBox<String> combo_failureType;
    public Button test;

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public FailureController() {
        conn=Connect.ConnectDB();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String sql = "SELECT * FROM failure";

        try{
            ps= conn.prepareStatement(sql);
            rs= ps.executeQuery(sql);
            while (rs.next()) {
                listCombo.add(rs.getString("Failure_Type"));
                combo_failureType.setItems(FXCollections.observableArrayList(listCombo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
