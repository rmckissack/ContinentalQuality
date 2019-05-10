package com.continentalquality;

import com.continentalquality.model.AvailableToShip;
import com.continentalquality.model.Datasource;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

public class ShippingController implements Initializable {

    //    hooking into FXML file to local variables
    @FXML
    private TableView<AvailableToShip> tableReady;
    @FXML
    private TableColumn<AvailableToShip, CheckBox> tableColumnSelect;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnId;
    @FXML
    private TableColumn<AvailableToShip, String> tableColumnLot;
    @FXML
    private TableColumn<AvailableToShip, String> tableColumnPart;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnPerBox;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnPerSkid;
    @FXML
    private TableColumn<AvailableToShip, Boolean> tableColumnCompleted;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnBoxed;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnShipped;
    @FXML
    private TableColumn<AvailableToShip, Integer> tableColumnToShip;

    @FXML
    private Button loadData;

    public ObservableList<AvailableToShip> data;
    public List<AvailableToShip> lots;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GetData();
        tableReady.setSelectionModel(null);
    }

    public void GetData() {

//        open and test database connection
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open Database");
        }

//  query database and check success
        lots = datasource.queryReadyToShip();
        if (lots == null) {
            System.out.println("No lots available!");
            return;
        }
        data = FXCollections.observableArrayList();

//        this loop is used when I need to check data returned in list
        for (AvailableToShip lot : lots) {
            System.out.println("ID Number = " + lot.getReadyLotId() + ", Part Number = " +
                    lot.getReadyPartNumber() + ", Lot Number = " + lot.getReadyLotNumber() + ", Per Box = " + lot.getReadyPerBox() +
                    ", Completed = " + lot.isReadyCompleted());
        } // Close for loop


//        copy list "lots" that was pulled from database to observableList for use in UI
        ObservableList<AvailableToShip> data = FXCollections.observableArrayList(lots);

//  assign data to columns in tableView
        tableColumnSelect.setCellValueFactory(new PropertyValueFactory<AvailableToShip, CheckBox>("select"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("readyLotId"));
        tableColumnLot.setCellValueFactory(new PropertyValueFactory<>("readyLotNumber"));
        tableColumnPart.setCellValueFactory(new PropertyValueFactory<>("readyPartNumber"));
        tableColumnPerBox.setCellValueFactory(new PropertyValueFactory<>("readyPerBox"));
        tableColumnPerSkid.setCellValueFactory(new PropertyValueFactory<>("readyPerSkid"));
        tableColumnCompleted.setCellValueFactory(new PropertyValueFactory<>("readyCompleted"));
        tableColumnBoxed.setCellValueFactory(new PropertyValueFactory<>("readyBoxed"));
        tableColumnShipped.setCellValueFactory(new PropertyValueFactory<>("readyShipped"));
        tableColumnToShip.setCellValueFactory(new PropertyValueFactory<>("readyToShip"));

//        first make sure the table is empty then populate it with the data in observableList
        tableReady.setItems(null);
        tableReady.setItems(data);

    }

    public List<AvailableToShip> selectedToShip() {
        List<AvailableToShip> selectedForShipping = new ArrayList<>();
        for(AvailableToShip checking : data) {
            if(checking.getSelect().isSelected()) {
                selectedForShipping.add(checking);
            }
        }
        return selectedForShipping;
    }

    //    button to refresh database list
    @FXML
    private void loadData(ActionEvent event) {
        GetData();
    }


    @FXML
    private void shipSelected(ActionEvent event) {
        selectedToShip();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SelectedShipping.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Selected For Shipping");
            stage.setScene(new Scene(root2));
            stage.show();


        } catch (Exception e) {
            System.out.println("Problem loading new window: " + e);

        }



    }


//    ObservableList<AvailableToShip> selectedForShipping = FXCollections.observableArrayList();


}





