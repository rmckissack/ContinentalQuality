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

    private Task<ObservableList<AvailableToSort>> task;
    @FXML
    private ComboBox selectLotCombo;


    public void initialize() {
        System.out.println("entering initialize");
        task = new Task<ObservableList<AvailableToSort>>() {
            @Override
            protected ObservableList<AvailableToSort> call() throws Exception {
                final ObservableList<AvailableToSort> availables = FXCollections.observableArrayList(Datasource.getInstance().queryAvailableLot());
                System.out.println("Observable called");
                System.out.println(availables);
                return availables;
            }
        };

    selectLotCombo.itemsProperty().bind(task.valueProperty());
    }
    @FXML
    public void comboMouse() {
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




















