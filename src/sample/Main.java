package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Spirograph");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(700);

        Group root = new Group(root1);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
