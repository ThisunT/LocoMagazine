package UI.Index;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * Created by Thisun Pathirage on 9/7/2017.
 */
public class IndexController implements Initializable{

    public  AnchorPane holderDash;

    public AnchorPane locomotives,failures,trips,delays,schedule,maintenance, employees, locoposition;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Load all fxmls in a cache
        try {
            locomotives = FXMLLoader.load(getClass().getResource("../Dashboard/Locomotive/locomotive.fxml"));
           /* failures = FXMLLoader.load(getClass().getResource("Alerts.fxml"));
            trips = FXMLLoader.load(getClass().getResource("Pricing.fxml"));
            delays = FXMLLoader.load(getClass().getResource("Profiles.fxml"));
            schedule = FXMLLoader.load(getClass().getResource("Widgets.fxml"));
            maintenance = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            employees = FXMLLoader.load(getClass().getResource("Controls.fxml"));
            locoposition = FXMLLoader.load(getClass().getResource("Controls.fxml")); */
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Set selected node to a content holder

    public void transPane(){
        holderDash.getChildren().clear();
    }

    private void setNode(Node node) {
        holderDash.getChildren().clear();
        holderDash.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1000));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void switchLocomotives(ActionEvent event) {
        setNode(locomotives);
    }

    /*@FXML
    private void switchContacts(ActionEvent event) {
        setNode(contacts);
    }

    @FXML
    private void switchWidget(ActionEvent event) {
        setNode(widgets);
    }

    @FXML
    private void switchProfile(ActionEvent event) {
        setNode(profiles);
    }

    @FXML
    private void switchAlert(ActionEvent event) {
        setNode(alerts);
    }

    @FXML
    private void switchControls(ActionEvent event) {
        setNode(controls);
    }
    */
}
