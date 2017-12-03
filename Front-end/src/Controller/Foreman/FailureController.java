package Controller.Foreman;

import UI.Index.Connect;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static java.util.Arrays.asList;


/**
 * Created by piumiindeevari on 10/20/2017.
 */
public class FailureController implements Initializable {


        List<String> listComboF = new ArrayList<>();
        List<String> listComboR = new ArrayList<>();
        List<String> listComboE = new ArrayList<>();
        List<String> listComboS = new ArrayList<>(asList("Dead","Idle","Running"));

        public ComboBox<String> combo_failureName;
        public ComboBox<String> combo_route;
        public ComboBox<String> combo_engineType;
        public ComboBox<String> combo_engineState;
        public Button btn_submit;
        public TextField txt_time;
        public TextField txt_place;
        public TextField txt_nearestYard;
        public TextArea txt_counteraction;
        public TextArea txt_Dnote;
        public TextArea txt_description;


        private Connection conn = null;
        private PreparedStatement ps = null;
        private ResultSet rs = null;



        public FailureController() {
            conn= Connect.ConnectDB();

        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            this.fillCombo_failureName();
            this.fillCombo_route();
            this.fillCombo_engineType();
            this.fillCombo_engineState();
            this.setTime();

        }
//Set Combo box lists: Engine Class, Failure Name, Route, Engine State

        void fillCombo_failureName(){
            String sql = "SELECT * FROM engine_failure";

            try{
                ps= conn.prepareStatement(sql);
                rs= ps.executeQuery(sql);
                while (rs.next()) {
                    listComboF.add(rs.getString("name"));
                    listComboF.add("Other");
                    combo_failureName.setItems(FXCollections.observableArrayList(listComboF));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void fillCombo_route(){
            String sql = "SELECT * FROM route";

            try{
                ps= conn.prepareStatement(sql);
                rs= ps.executeQuery(sql);
                while (rs.next()) {
                    listComboR.add(rs.getString("name"));
                    combo_route.setItems(FXCollections.observableArrayList(listComboR));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void fillCombo_engineType(){
            String sql = "SELECT * FROM loco_class";

            try{
                ps= conn.prepareStatement(sql);
                rs= ps.executeQuery(sql);
                while (rs.next()) {
                    listComboE.add(rs.getString("class"));
                    combo_engineType.setItems(FXCollections.observableArrayList(listComboE));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void fillCombo_engineState(){

            combo_engineState.setItems(FXCollections.observableArrayList(listComboS));

        }

        void setTime(){
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            txt_time.setText(dateFormat.format(date));
        }

//Insert data to the database

      /* void insertData(){
            String sql = "INSERT INTO " + "failure_occuered(place, nearest_yard, time, loco_state_at_failure, driver's_note, failure_description)"
                    + "VALUES(?, ?, ?, ?, ?, ?)";


            try{
                ps= conn.prepareStatement(sql);
                rs= ps.executeQuery(sql);
                while (rs.next()) {
                    listComboE.add(rs.getString("class"));
                    combo_engineType.setItems(FXCollections.observableArrayList(listComboE));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/



}
