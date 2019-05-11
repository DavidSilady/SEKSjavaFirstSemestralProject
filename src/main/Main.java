package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DataStorage;

/**
 * SECS - Sub-governmental Evidence and Control System
 * is a demo application for management of devices a company should run an evidence of.
 * This application only contains two types of devices - Electronic (ED) and Gas (GD).
 * There are three user types, who interact with the devices:
 *      - Company User
 *          - owns, adds and removes devices
 *          - asks inspector users for their assignment to the company
 *          - revokes inspector user assignments
 *      - Inspector User
 *          - accepts assignments from companies
 *          - views assigned companies and their devices,
 *          - removes or adds devices
 *          - marks devices as inspected
 *      - Auditor User (governmental)
 *          - views all other users (with their devices)
 *          - removes any user
 *          - signs up new inspector users
 *          - marks devices as audited
 * The whole system of calculating next audition or inspection is automated.
 * If a new audition/inspection is required, the company is notified via notification system.
 *
 * @author David Silady
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        class InitThread extends Thread {
            /**
             * Used for deserialization while loading first pane
             */
            public void run(){
                DataStorage.getInstance().init();
            }
        }
        InitThread initThread = new InitThread();
        initThread.start();
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

