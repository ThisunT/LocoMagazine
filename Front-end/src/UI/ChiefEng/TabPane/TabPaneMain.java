package UI.ChiefEng.TabPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Toshiba® on 18-Oct-17.
 */

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


