package Controller.Foreman;

import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class FailureController implements Initializable {

        String failure;
        String Faiure_Type;
        List<String> listCombo = new ArrayList<>();

        public ComboBox<String> combo_failureType;
        public Button test;

        private Connection conn = null;
        private PreparedStatement ps = null;
        private ResultSet rs = null;



        public FailureController() {
            conn= Connect.ConnectDB();

        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            this.fillCombo_FailureType();

        }


        void fillCombo_FailureType(){
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

        void setCombo_FailureType(){
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
