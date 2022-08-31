/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.View;

import ch.bbbaden.tradingjournal.Entity.Trades;
import ch.bbbaden.tradingjournal.ViewModel.ViewTradesViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dario
 */
public class ViewTrades implements Initializable {

    private ViewTradesViewModel viewTradesViewModel;
    @FXML
    private TableView<Trades> table;
    @FXML
    private TableColumn<Trades, String> tPair;
    @FXML
    private TableColumn<Trades, String> tBS;
    @FXML
    private TableColumn<Trades, String> tDate;
    @FXML
    private TableColumn<Trades, String> tTime;
    @FXML
    private TableColumn<Trades, String> tWBEL;
    @FXML
    private TableColumn<Trades, String> tStrat;
    @FXML
    private TableColumn<Trades, String> tProfit;
    @FXML
    private TableColumn<Trades, String> tReasonsF;
    @FXML
    private TableColumn<Trades, String> tReasonsA;
    @FXML
    private TableColumn<Trades, String> tOthers;
    @FXML
    private TableColumn<Trades, String> tLearn;
    @FXML
    private Button btnView;
    @FXML
    private Button btnEdit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tPair.setCellValueFactory(new PropertyValueFactory<>("pair"));
        tBS.setCellValueFactory(new PropertyValueFactory<>("bs"));
        tDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tWBEL.setCellValueFactory(new PropertyValueFactory<>("wbel"));
        tStrat.setCellValueFactory(new PropertyValueFactory<>("strat"));
        tProfit.setCellValueFactory(new PropertyValueFactory<>("profit"));
        tReasonsF.setCellValueFactory(new PropertyValueFactory<>("reasonsF"));
        tReasonsA.setCellValueFactory(new PropertyValueFactory<>("reasonsA"));
        tOthers.setCellValueFactory(new PropertyValueFactory<>("others"));
        tLearn.setCellValueFactory(new PropertyValueFactory<>("learn"));
    }

    public void setViewTradesViewModel(ViewTradesViewModel viewTradesViewModel) {
        this.viewTradesViewModel = viewTradesViewModel;
    }

    @FXML
    public void switchSceneAddTrade(ActionEvent event) throws IOException {
        viewTradesViewModel.switchScene("View/AddTrade.fxml");
    }

    public void addItemsToTable() {
        table.setItems(viewTradesViewModel.getListFromModel());
    }

    @FXML
    public void enableButtons() {
        btnView.setDisable(false);
        btnEdit.setDisable(false);
    }

    @FXML
    public void viewTradeInDetail() throws IOException {
        ObservableList<Trades> rowList = table.getSelectionModel().getSelectedItems();
        if (table.getSelectionModel().getSelectedItem() != null) {
            viewTradesViewModel.switchScene("View/ViewSelectedTrade.fxml");
            viewTradesViewModel.viewTradeInDetail(rowList.get(0).getPair(), rowList.get(0).getBs(), rowList.get(0).getDate(), rowList.get(0).getTime(), rowList.get(0).getWbel(), rowList.get(0).getStrat(), rowList.get(0).getProfit(), rowList.get(0).getReasonsF(), rowList.get(0).getReasonsA(), rowList.get(0).getOthers(), rowList.get(0).getLearn());
        }
    }

    @FXML
    public void editTrade() throws IOException {
        ObservableList<Trades> rowList = table.getSelectionModel().getSelectedItems();
        if (table.getSelectionModel().getSelectedItem() != null) {
            viewTradesViewModel.switchScene("View/EditTrade.fxml");
            viewTradesViewModel.updateOldValues(rowList.get(0).getPair(), rowList.get(0).getBs(), rowList.get(0).getDate(), rowList.get(0).getTime(), rowList.get(0).getWbel(), rowList.get(0).getStrat(), rowList.get(0).getProfit(), rowList.get(0).getReasonsF(), rowList.get(0).getReasonsA(), rowList.get(0).getOthers(), rowList.get(0).getLearn());
        }
    }
}
