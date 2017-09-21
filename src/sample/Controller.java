package sample;
import connection.ObjectToJson;
import javafx.scene.control.TextArea;

public class Controller {

    public TextArea textAreaState;
    public TextArea textAreaName;

    public void buttonSendClicked() {
        String state = textAreaState.getText();
        String name = textAreaName.getText();

        Locomotive loco = new Locomotive();

        loco.setState(state);
        loco.setName(name);

        String locoObject = ObjectToJson.convertor(loco);
        System.out.println(locoObject);

    }

}
