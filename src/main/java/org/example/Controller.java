package org.example;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    public Label bandwitdh;
    MySql mySql=new MySql();
    Integer a;
    String band;
    String dure;

    @FXML
    private TextField firstNameTF, lastNameTF, addressTF;

    @FXML
    private ToggleGroup speedGroup, bandGroup, drGroup;

    @FXML
    private TableView<Person> table;

    @FXML
    private TableColumn<Person, Integer> tcId;
    @FXML
    private TableColumn<Person, String> tcAddress;

    @FXML
    private TableColumn<Person, String> tcBandwidth;

    @FXML
    private TableColumn<Person, String> tcDuration;

    @FXML
    private TableColumn<Person, String> tcFirstName;

    @FXML
    private TableColumn<Person, String> tcLastName;


    @FXML
    private TableColumn<Person, Integer> tcSpeed;

    @FXML
    private Button closeBT;




    public Controller() {

    }


    @FXML
    private void initialize() throws SQLException {
        closeBT.setMaxSize(25,25);
        ObservableList<Person> peopl= FXCollections.<Person>observableArrayList(mySql.select());
        table.setItems(peopl);

        speedGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    ToggleButton selected = (ToggleButton) newValue;

                    switch (selected.getText()) {
                        case "2":
                            a = 2;
                            break;
                        case "5":
                            a = 5;
                            break;
                        case "10":
                            a = 10;
                            break;
                        case "20":
                            a = 20;
                            break;
                        case "50":
                            a = 50;
                            break;
                        case "100":
                            a = 100;
                            break;
                    }
                }

            }
        });
        bandGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    ToggleButton selected = (ToggleButton) newValue;

                    switch (selected.getText()) {
                        case "1":
                            band = "1";
                            break;
                        case "5":
                            band = "5";
                            break;
                        case "10":
                            band = "10";
                            break;
                        case "100":
                            band = "100";
                            break;
                        case "Flat":
                            band = "Flat";
                            break;
                    }
                }
            }
        });
        drGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    ToggleButton selected = (ToggleButton) newValue;

                    switch (selected.getText()) {
                        case "1 year":
                            dure = "1 year";
                            break;
                        case "2 years":
                            dure = "2 years";
                            break;
                    }
                }
            }
        });




        tcId.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        tcSpeed.setCellValueFactory(new PropertyValueFactory<Person, Integer>("speed"));
        tcBandwidth.setCellValueFactory(new PropertyValueFactory<Person, String>("bandwidth"));
        tcDuration.setCellValueFactory(new PropertyValueFactory<Person, String>("duration"));



    }


    @FXML
    public void savePerson() throws SQLException {
        if(!firstNameTF.getText().isEmpty()&&!lastNameTF.getText().isEmpty()&&!addressTF.getText().isEmpty()&&a!=null&&band!=null&&dure!=null){
            /*table.getItems().add(new Person(firstNameTF.getText(), lastNameTF.getText(), addressTF.getText(), a, band, dure));*/

            Person person=new Person(firstNameTF.getText(), lastNameTF.getText(), addressTF.getText(), a, band, dure);
            mySql.insert(person);
            ObservableList<Person> peopl= FXCollections.<Person>observableArrayList(mySql.select());
            table.setItems(peopl);
            firstNameTF.setText("");
            lastNameTF.setText("");
            addressTF.setText("");
            a=null;
            band=null;
            dure=null;
            speedGroup.getSelectedToggle().setSelected(false);
            drGroup.getSelectedToggle().setSelected(false);
            bandGroup.getSelectedToggle().setSelected(false);


        }else {
            a=null;
            band=null;
            dure=null;
            Alert alert= new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Error! Please check again!");
            alert.showAndWait();
        }



    }

    @FXML
    public void clearTable() throws SQLException {

                System.out.println("ss");
                mySql.clearAll();
                table.getItems().clear();



    }


    @FXML
    public void deleteRow() throws SQLException {
        Person person= (Person) table.getSelectionModel().getSelectedItem();
        mySql.delete(person);
        table.getItems().remove(person);
    }

    @FXML
    public void exit(){
        Platform.exit();
    }


}
