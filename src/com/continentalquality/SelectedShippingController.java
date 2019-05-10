package com.continentalquality;

import com.continentalquality.model.AvailableToShip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import com.continentalquality.ShippingController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectedShippingController implements Initializable {
    public ObservableList<AvailableToShip> listOfSelected;
    public List<AvailableToShip> selects;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//       getListToShip();

    }


//    public void getListToShip() {
//
//        selects = ShippingController.selectedToShip();
//        if (selects == null) {
//            System.out.println("No selections available!");
//            return;
//        }
//        listOfSelected = FXCollections.observableArrayList();
//
//    }

//    ObservableList<AvailableToShip> listOfSelected = FXCollections.observableArrayList(selects);






}
