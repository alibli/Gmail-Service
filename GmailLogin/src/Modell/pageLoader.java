package Modell;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.nio.file.Paths;

public class pageLoader {



    static int WIDTH = 401;
    static int HEIGHT = 601;
    private static Stage stage ;

    public static void initstage(Stage primarystage) {

        stage = primarystage;

        stage.setTitle("GmailService");
        stage.setResizable(true);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.initStyle(StageStyle.DECORATED);
        stage.getIcons().add(new Image(Paths.get("C:\\Users\\IRANICA\\Desktop\\GmailLogin\\src\\Vieww\\Gmail_Icon.png").toUri().toString()));

    }

    public void load(String url) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(url));
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();

    }

}
