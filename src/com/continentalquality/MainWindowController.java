package com.continentalquality;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController {

    @FXML
    private BorderPane rootPane;


    @FXML
    private void loadTally(ActionEvent event) throws IOException {
        BorderPane pane = FXMLLoader.load(getClass().getResource("TallySheetWindow.fxml"));
        rootPane.getChildren().setAll(pane);
    }

}
