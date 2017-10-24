package UI.Dashboard.Locomotive;

import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Thisun Pathirage on 10/21/2017.
 */
public class LocomotiveViewer {



    Pagination pagination = new Pagination();

    public AnchorPane createPage(int numberOfObjects, int pageIndex, JSONArray response) {
        AnchorPane boxAnchor = new AnchorPane();
        boxAnchor.prefWidth(1090.0); boxAnchor.prefHeight(740.0); boxAnchor.setStyle("-fx-background-color: #f1f1f1;");

        VBox box1 = new VBox(5);
        box1.setLayoutX(39.0); box1.setLayoutY(115.0); box1.setSpacing(15.0);
        boolean var = false;

        for (int i = pageIndex*4; i < 2+pageIndex*4; i++) {
            if(i==numberOfObjects){
                var = true;
                break;
            }
            else {
                VBox element = new VBox();
                LocoProfile locoProfile = new LocoProfile();
                try {
                    locoProfile.setLocoNumber(response.getJSONObject(i).getInt("EngineNumber"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AnchorPane obj = locoProfile.createLocoProfile();
                element.getChildren().add(obj);
                box1.getChildren().add(element);
            }

        }

        VBox box2 = new VBox(5);
        box2.setLayoutX(570.0); box2.setLayoutY(115.0); box2.setSpacing(15.0);

        for (int j = 2+pageIndex*4; j < 4+pageIndex*4; j++) {
            if(var){
                break;
            }
            if(j==numberOfObjects){
                break;
            }
            else {
                VBox element = new VBox();
                LocoProfile locoProfile = new LocoProfile();
                AnchorPane obj = locoProfile.createLocoProfile();
                element.getChildren().addAll(obj);
                box2.getChildren().add(element);
            }

        }

        boxAnchor.getChildren().addAll(box1,box2);
        return boxAnchor;
    }

    public AnchorPane pages(){
        JSONArray response = LocomotiveViewerController.getResponse();
        int pageCount=((LocomotiveViewerController.numberOfObjects())/4+(LocomotiveViewerController.numberOfObjects())%4);
        int numberOfObjects = LocomotiveViewerController.numberOfObjects();

        pagination = new Pagination(pageCount, 0);
        pagination.setPrefHeight(720.0); pagination.setPrefWidth(1090.0);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                return createPage(numberOfObjects, pageIndex, response);
            }
        });

        AnchorPane anchor = new AnchorPane();
        anchor.prefWidth(1090.0); anchor.prefHeight(740.0); anchor.setStyle("-fx-background-color: #f1f1f1;");
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 5.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchor.getChildren().addAll(pagination);

        return anchor;
    }
}
