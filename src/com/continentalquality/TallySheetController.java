package com.continentalquality;

/*
 * Created by Randy McKissack 2019/04/23
 *
 */

import com.continentalquality.model.AvailableToSort;
import com.continentalquality.model.Datasource;
import com.continentalquality.model.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TallySheetController{

    private Task<ObservableList<String>> task;
    @FXML
    private ComboBox selectLotCombo;


    public void initialize() {
        System.out.println("entering initialize");
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                System.out.println("entering initialize2");
                ObservableList<String> availables = FXCollections.observableArrayList("123456", "4343434", "4444444");
                System.out.println("Observable called");
                return availables;
//                Datasource.getInstance().queryAvailableLot()
            }
        };

    selectLotCombo.itemsProperty().bind(task.valueProperty());

    }
    @FXML
    public void kickoffButton() {
        new Thread(task).start();
        System.out.println("Task kicked");
    }


}

//class GetAvailableToSort extends Task {
//
//
//    @Override
//    public ObservableList<AvailableToSort> call() {
//        return FXCollections.observableArrayList(Datasource.getInstance().queryAvailableLot());
//
//
//    }
//
//}




















