package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Table;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class PosController {
    public TableView<Table> tbv;
    public TableColumn<Table, Integer> colID;
    public TableColumn<Table, String> colName;
    public TableColumn<Table, Integer> colQty;
    public TableColumn<Table, Double> colPrice;
    public Label qty1;
    ObservableList<Table> list = FXCollections.observableArrayList();
    public void addTable(int id, int qty ,String name,  Double price) {
        // product already add
//        int rowLen = tbv.row;
//        for (int row = 0; row < rowLen; row++) {
//
//        }

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Table tb = new Table(id, qty, name, price);
        list.add(tb);
        tbv.setItems(list);
    }

    public void addToTable(MouseEvent mouseEvent) {
        int count = Integer.parseInt(qty1.getText());
        count ++;
        qty1.setText(String.valueOf(count));

        addTable(1, count,"Tocotoco-$3.99", 3.99);
    }
}
