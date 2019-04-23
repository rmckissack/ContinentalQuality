package com.continentalquality;

/*
 * Created by Randy McKissack 2019/04/23
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TallySheet extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TallySheetWindow.fxml"));
        primaryStage.setTitle("Continental Quality");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.show();
    }


//    public static void main(String[] args) {
//        launch(args);
//    }
}