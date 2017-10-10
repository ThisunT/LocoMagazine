package UI;/**
 * Created by Thisun Pathirage on 9/7/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/UI.Index/index.fxml"));
        primaryStage.setTitle("Railway");
        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


}
