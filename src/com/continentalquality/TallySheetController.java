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

import java.util.ResourceBundle;

public class TallySheetController{

//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
////    selectLotCombo.setItems(names);
//    }

    @FXML
            ComboBox selectLotCombo;

    ObservableList<AvailableToSort> names = FXCollections.observableArrayList(Datasource.getInstance().queryAvailableLot());


//    public ObservableList<AvailableToSort> getNames() {
//        return names;
//    }
//
//    public void setNames(ObservableList<AvailableToSort> names) {
//        this.names = names;
//    }
}

//class GetAvailableToSort extends Task {
//
//
//
//    @FXML
//    @Override
//    public ObservableList<AvailableToSort> call() {
//        return FXCollections.observableArrayList(Datasource.getInstance().queryAvailableLot());
//
//
//    }
//
//}




















