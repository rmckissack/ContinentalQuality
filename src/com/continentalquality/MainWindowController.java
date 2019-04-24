package com.continentalquality;

/*
 * Created by Randy McKissack 2019/04/23
 *
 */

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.Modality;

import java.io.IOException;

public class MainWindowController {

    @FXML
    public Button tallyButton;

    @FXML
    public Button tallyMenuLink;

    @FXML
    public void tallyButtonClick(ActionEvent actionEvent) throws IOException {
        Window mainWindow = tallyButton.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("TallySheetWindow.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

    @FXML
    public void tallyMenuClicked(ActionEvent actionEvent) throws IOException {
        Window mainWindow = tallyMenuLink.getScene().getWindow();
        Parent newRoot = FXMLLoader.load(getClass().getResource("TallySheetWindow.fxml"));
        mainWindow.getScene().setRoot(newRoot);
    }

}
