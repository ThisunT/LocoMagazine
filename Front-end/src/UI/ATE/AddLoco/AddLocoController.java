package UI.ATE.AddLoco;

import Connection.ObjectToJson;
import Connection.PostRequest;
import Models.Locomotive;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Thisun Pathirage on 10/10/2017.
 */
public class AddLocoController {

    @FXML
    private ChoiceBox engineType;
    @FXML
    private TextField engineNo;
    @FXML
    private DatePicker dateToday;
    @FXML
    private TextArea manufacturer;
    @FXML
    private TextArea topSpeed;
    @FXML
    private ComboBox currentState;
    @FXML
    private DatePicker dateManufactured;
    @FXML
    private TextArea shedAllocated;

    private String addLocoUrl = "http://localhost:3000/api/locomotive";


    public void submitClicked(){

        Locomotive loco = new Locomotive();
        loco.setEngineNumber(Integer.parseInt(engineNo.getText()));
        loco.setEngineType((String) engineType.getValue());
        loco.setManufacturedDay(dateManufactured.getValue());
        loco.setManufacturer(manufacturer.getText());
        loco.setShed(shedAllocated.getText());
        loco.setToday(dateToday.getValue());
        loco.setTopSpeed(Integer.parseInt(topSpeed.getText()));
        loco.setState((String) currentState.getValue());

        String locoObject = ObjectToJson.converter(loco);
        System.out.println(locoObject);

        try {
            PostRequest.sendPostRequest(addLocoUrl,locoObject);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


}
