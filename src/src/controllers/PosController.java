package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Table;

public class PosController {
    public TableView<Table> tbv;
    public TableColumn<Table, Integer> colID;
    public TableColumn<Table, String> colName;
    public TableColumn<Table, Integer> colQty;
    public TableColumn<Table, Double> colPrice;
    public Label qty1;
    public Label total;
    ObservableList<Table> list = FXCollections.observableArrayList();
    public static Table resetTable;
    public void addTable(int id, int qty ,String name,  Double price) {
        // product already add
//            for (int i = 0; i <= list.size(); i++) {
//                list.remove(list.get(i));
//            }
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        Table tb = new Table(id, qty, name, price);
        list.add(tb);
        tbv.setItems(list);
        tbv.refresh();
    }

    public void addToTable(MouseEvent mouseEvent) {
        int count = Integer.parseInt(qty1.getText());
        count ++;
        qty1.setText(String.valueOf(count));

        Double price = count * 3.99;
        addTable(1, count,"Tocotoco-$" + 3.99, price);
        total.setText("$" + price);
    }

    public void reset(ActionEvent mouseEvent) {
        try {
            qty1.setText("0");
            total.setText("$0.0");
            tbv.setItems(list);
            tbv.refresh();
            resetTable = null;
            resetTable = tbv.getSelectionModel().getSelectedItem();
            if (resetTable != null) {
                for (int i = 0; i <= list.size(); i++) {
                    list.remove(list.get(i));
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
}
