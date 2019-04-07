package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataStorage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        DataStorage.getInstance().init();
        Parent root = FXMLLoader.load(getClass().getResource("../view/chooseUser.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("SEKS");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

