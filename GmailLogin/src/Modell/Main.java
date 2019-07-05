package Modell;

import Modell.LoadMembers;
import Modell.pageLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * this is a simple code for Gmail
 * @author Ali.b
 */


public class Main extends Application {

   private static Socket socket ;
    public static ObjectInputStream input;
    public static ObjectOutputStream output;

    @Override
    public void init() throws IOException, ClassNotFoundException {
        /**
         * initialize server and connect to server
         */

        socket = new Socket("localhost" , 8888);
           //System.out.println(1);
        output = new ObjectOutputStream(socket.getOutputStream());
           //System.out.println(output);
        input = new ObjectInputStream(socket.getInputStream());
           //System.out.println(input);

           System.out.println("before");
   //        LoadMembers.initMembers();              // bargozarie member ha dar ebtedaye barname

    }

    @Override
    public void stop() {
        System.out.println("after app");
        //close
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        pageLoader.initstage(primaryStage);
        new pageLoader().load("/vieww/sample.fxml");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
