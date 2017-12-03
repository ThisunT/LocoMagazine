package UI.Index;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * Created by acer on 10/9/2017.
 */
public class login_controller implements Initializable {

    public TextField tf_login;
    public Button btn_login;
    public TextField tf_uname;
    public PasswordField btn_pwd;

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public login_controller() {
        conn = Connect.ConnectDB();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    public void okBtnAction(ActionEvent event) throws SQLException, IOException {

        String username = tf_uname.getText().toString();
        String pwd = btn_pwd.getText().toString();

        String sql = "SELECT * FROM user WHERE username = ? and pwd = ?";

        try{
            ps= conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, pwd);
            rs= ps.executeQuery();

            if (rs.next()) {
                infoBox("Login Successfull", "Success", null);
                ((Node)(event.getSource())).getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Main");
                stage.show();

            } else {
                infoBox("Enter Correct Username and Password", "Failed", null);
                tf_uname.setText("");
                btn_pwd.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void infoBox(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }



}

