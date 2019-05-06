package com.continentalquality;

import com.continentalquality.model.AvailableToShip;
import com.continentalquality.model.Datasource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShippingController implements Initializable {

    @FXML private TableView<AvailableToShip> tableReady;
    @FXML private TableColumn<AvailableToShip, Integer> tableColumnId;
    @FXML private TableColumn<AvailableToShip, String> tableColumnLot;
    @FXML private TableColumn<AvailableToShip, String> tableColumnPart;
    @FXML private TableColumn<AvailableToShip, Boolean> tableColumnCompleted;
    @FXML private Button loadData;

    public ObservableList<AvailableToShip> data;
    public List<AvailableToShip> lots;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GetData();
        tableReady.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void GetData() {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open Database");
        }


        lots = datasource.queryReadyToShip();
        if(lots == null) {
            System.out.println("No lots available!");
            return;
        }
        data = FXCollections.observableArrayList();
        for(AvailableToShip lot : lots) {

            System.out.println("ID Number = " + lot.getReadyLotId() + ", Part Number = " +
                    lot.getReadyPartNumber() + ", Lot Number = " + lot.getReadyLotNumber() +
                    ", Completed = " + lot.isReadyCompleted());

//        data.add(new AvailableToShip(lot.getReadyLotId(), lot.getReadyLotNumber(), lot.getReadyPartNumber(), lot.isReadyCompleted()));

        } // Close for loop
        ObservableList<AvailableToShip> data = FXCollections.observableArrayList(lots);


        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("readyLotId"));
        tableColumnLot.setCellValueFactory(new PropertyValueFactory<>("readyLotNumber"));
        tableColumnPart.setCellValueFactory(new PropertyValueFactory<>("readyPartNumber"));
        tableColumnCompleted.setCellValueFactory(new PropertyValueFactory<>("readyCompleted"));

//    tableReady.setItems(null);
        tableReady.setItems(data);

    }

    @FXML
    private void loadData(ActionEvent event) {
        GetData();
    }





}







