package UI.Index;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by acer on 10/9/2017.
 */
public class Index_controller implements Initializable {

    public AnchorPane loadPane;
    public AnchorPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    public void pressButton1(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Home/EngineProfile.fxml"));
        loadPane.getChildren().setAll(pane);
    }

    public void pressButton2(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Home/Failiure.fxml"));
        loadPane.getChildren().setAll(pane);
    }

    public void pressButton3(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Home/TripDetails.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void pressButton7(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Home/EmployeeProfile.fxml"));
        loadPane.getChildren().setAll(pane);
    }

    public void pressButton8(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../Home/loco.fxml"));
        loadPane.getChildren().setAll(pane);
    }
    public void homeButton(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("index.fxml"));
        mainPane.getChildren().setAll(pane);
    }

}