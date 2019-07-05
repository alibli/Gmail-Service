package Controllerr;

import Modell.LoadMembers;
import Modell.Member;
import Modell.pageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoginController {

    @FXML
    public TextField UsernameID;
    @FXML
    public PasswordField PasswordID;
    @FXML
    public Label WrongID;
    @FXML
    public Button ButtonID;
    @FXML
    public Button signupID;


    public void signup(ActionEvent actionEvent) throws IOException {
        new pageLoader().load("/Vieww/SignupScene.fxml");
    }


    public void login(ActionEvent actionEvent) throws IOException {
        boolean flag = false;
        for ( Member mem: LoadMembers.ALLMEMBERS ) {
            if (UsernameID.getText().equalsIgnoreCase(mem.getUsername()) &&
                    PasswordID.getText().equalsIgnoreCase(mem.getPassword())) {

                new pageLoader().load("/Vieww/MainScene.fxml");
                flag = true;
            }
            else
                continue;

        }

        if (flag == false)
        WrongID.setVisible(true);

    }



}
