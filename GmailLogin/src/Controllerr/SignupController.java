package Controllerr;

import Modell.LoadMembers;
import Modell.Main;
import Modell.Member;
import Modell.pageLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.Message;
import utility.MessageType;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class SignupController {

    @FXML
    public TextField usernameID;
    @FXML
    public TextField passwordID;
    @FXML
    public TextField nameID;
    @FXML
    public TextField repassID;
    @FXML
    public TextField lastnameID;
    @FXML
    public Label noaccountID;
    @FXML
    public TextField ageID;
    @FXML
    public Button createaccountID;
    @FXML
    public Label passcharID;
    @FXML
    public Label samepassID;


    Member member = new Member();


    public void CreateAccount(ActionEvent actionEvent) throws Exception {

        String ageid = ageID.getText();
//        Integer age = Integer.parseInt(ageid);


        if (passwordID.getText().isEmpty() || usernameID.getText().isEmpty() || nameID.getText().isEmpty() ||
                repassID.getText().isEmpty() || lastnameID.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "please fill all fields :)");
            alert.showAndWait();
        }


        if (Integer.parseInt(ageID.getText()) >= 13) {
            if (passwordID.getText().length() >= 8) {
                if (passwordID.getText().equalsIgnoreCase(repassID.getText())) {

                    member.setName(nameID.getText());
                    member.setAge(ageid);
                    member.setLastname(lastnameID.getText());
                    member.setUsername(usernameID.getText());
                    member.setPassword(passwordID.getText());


                    Message message = new Message() ;
                    message.setMessageType(MessageType.CreateAccount);
                      //System.out.println(MessageType.CreateAccount);
                    Main.output.writeObject(message);
                      //System.out.println(message);
                    Main.output.writeObject(member);
                      //System.out.println(member);


                    FileOutputStream f1 = new FileOutputStream("2.ser", true);
                    ObjectOutputStream out = new ObjectOutputStream(f1);
                    out.writeObject(member);
                    f1.close();
                    out.close();

                    LoadMembers.ALLMEMBERS.add(member);

                    new pageLoader().load("/vieww/sample.fxml");

                }
                else{
                    samepassID.setVisible(true);
                    passcharID.setVisible(false);
                    noaccountID.setVisible(false);
                }

            }
            else{

                passcharID.setVisible(true);
                noaccountID.setVisible(false);
                samepassID.setVisible(false);

            }



            //member = new Member();
        } else{
            noaccountID.setVisible(true);
            passcharID.setVisible(false);
            samepassID.setVisible(false);

        }


    }



}
