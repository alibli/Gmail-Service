package Controllerr;

import Modell.pageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.io.IOException;


public class MainController {

    @FXML
    public VBox vboxID;
    @FXML
    public TextArea textAreaID;
    @FXML
    public Button SendButtonID;
    @FXML
    public Button logoutID;


    public void Compose(ActionEvent actionEvent) {
        textAreaID.setVisible(true);
        SendButtonID.setDisable(false);
    }

    public void Send(ActionEvent actionEvent) {

    }

    public void logout(ActionEvent actionEvent) throws IOException {

        new pageLoader().load("/vieww/sample.fxml");

    }
}
