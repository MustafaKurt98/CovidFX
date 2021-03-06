package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Image virus=new Image("/images/resim.png");
        primaryStage.getIcons().add(virus);
        primaryStage.setTitle("CovidFX");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
