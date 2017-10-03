package UI.Foreman.TabPane;/**
 * Created by piumiindeevari on 9/21/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TabPaneMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("tabPane.fxml"));
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }
}
