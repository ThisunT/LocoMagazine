package UI.Dashboard.Locomotive;

/**
 * Created by Thisun Pathirage on 10/13/2017.
 */
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;

public class LocoProfile {

    private AnchorPane anchor =  new AnchorPane();
    private Label locoNumber = new Label();
    private Label locoType = new Label();
    private Label locoState = new Label();
    private Pane pane = new Pane();
    private JFXButton profile = new JFXButton();
    private ImageView imageView = new ImageView();

    public void setLocoNumber(int locoNumber) {
        this.locoNumber.setText(Integer.toString(locoNumber));
    }

    public void setLocoType(String locoType) {
        this.locoType.setText(locoType);
    }

    public void setLocoState(String locoState) {
        this.locoState.setText(locoState);
    }

    public AnchorPane createLocoProfile() {

        anchor.prefHeight(250.0); anchor.prefWidth(504.0); anchor.setStyle("-fx-background-radius: 3; -fx-border-radius: 3; -fx-border-color: #c3c3c3;");

        locoNumber.setLayoutX(34.0); locoNumber.setLayoutY(82.0); locoNumber.prefHeight(30.0); locoNumber.prefWidth(246.0); locoNumber.setStyle("-fx-text-fill: #73879C;");

        locoType.setLayoutX(34.0); locoType.setLayoutY(52.0); locoType.prefHeight(30.0); locoType.prefWidth(246.0); locoType.setStyle("-fx-text-fill: #73879C;");

        locoState.setLayoutX(34.0); locoState.setLayoutY(52.0); locoState.prefHeight(30.0); locoState.prefWidth(246.0); locoState.setStyle("-fx-text-fill: #73879C;");

        pane.setLayoutY(200.0); pane.prefHeight(50.0); pane.prefWidth(504.0); pane.setStyle("-fx-border-radius: 0 0 3 3; -fx-background-color: #E5E8EB; -fx-border-color: #C3C3C3; -fx-border-width: 1 0 0 1;");
        profile.setLayoutX(372.0); profile.setLayoutY(9.0); profile.prefHeight(32.0); profile.prefWidth(118.0); profile.setStyle("-fx-background-color: #337AB7; -fx-text-fill: white; -fx-font-size: 14;");
        profile.setText("View Profile");

        MaterialDesignIconView mDiv = new MaterialDesignIconView();
        mDiv.setFill(Paint.valueOf("#fffdfd"));
        mDiv.setGlyphName("TRAIN");
        mDiv.setSize("16.0");
        mDiv.setWrappingWidth(21.0);
        profile.setGraphic(mDiv);

        pane.getChildren().add(profile);

        Circle circle = new Circle();
        circle.setFill(Paint.valueOf("#e5e8eb")); circle.setLayoutX(399.0); circle.setLayoutY(104.0); circle.setRadius(75.0); circle.setStroke(Paint.valueOf("#c3c3c3")); circle.setStrokeType(StrokeType.INSIDE);

        Image image = new Image("UI/Images/train.png");
        imageView.setFitHeight(120.0); imageView.setFitWidth(120.0); imageView.setLayoutX(339.0); imageView.setLayoutY(44.0); imageView.setPickOnBounds(true); imageView.setPreserveRatio(true);
        imageView.setImage(image);
        anchor.getChildren().addAll(locoNumber, locoType, locoState, pane, circle, imageView);

        return anchor;
    }
}

