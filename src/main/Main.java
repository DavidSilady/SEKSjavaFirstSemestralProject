package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataStorage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        DataStorage userData = new DataStorage();
        DataStorage.init();
        Parent root = FXMLLoader.load(getClass().getResource("../view/chooseUser.fxml"));
        primaryStage.setTitle("SEKS");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

