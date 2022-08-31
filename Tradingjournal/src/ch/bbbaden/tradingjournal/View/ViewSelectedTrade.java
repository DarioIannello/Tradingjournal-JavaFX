/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.View;

import ch.bbbaden.tradingjournal.ViewModel.ViewSelectedTradeViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Dario
 */
public class ViewSelectedTrade implements Initializable {

    private ViewSelectedTradeViewModel viewSelectedTradeViewModel;

    @FXML
    private Label lblPair;
    @FXML
    private Label lblBS;
    @FXML
    private Label lblDate;
    @FXML
    private Label lblTime;
    @FXML
    private Label lblWBEL;
    @FXML
    private Label lblStrat;
    @FXML
    private Label lblProfit;
    @FXML
    private Label lblReasonF;
    @FXML
    private Label lblReasonA;
    @FXML
    private Label lblOther;
    @FXML
    private Label lblLearn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setViewSelectedTradeViewModel(ViewSelectedTradeViewModel viewSelectedTradeViewModel) {
        this.viewSelectedTradeViewModel = viewSelectedTradeViewModel;
    }

    @FXML
    public void switchSceneAddTrade(ActionEvent event) throws IOException {
        viewSelectedTradeViewModel.switchScene("View/AddTrade.fxml");
    }

    @FXML
    public void switchSceneViewTrades(ActionEvent event) throws IOException {
        viewSelectedTradeViewModel.switchScene("View/ViewTrades.fxml");
    }

    public void bind() {
        lblPair.textProperty().bind(viewSelectedTradeViewModel.getPair());
        lblBS.textProperty().bind(viewSelectedTradeViewModel.getBs());
        lblDate.textProperty().bind(viewSelectedTradeViewModel.getDate());
        lblTime.textProperty().bind(viewSelectedTradeViewModel.getTime());
        lblWBEL.textProperty().bind(viewSelectedTradeViewModel.getWbel());
        lblStrat.textProperty().bind(viewSelectedTradeViewModel.getStrat());
        lblProfit.textProperty().bind(viewSelectedTradeViewModel.getProfit());
        lblReasonF.textProperty().bind(viewSelectedTradeViewModel.getReasonF());
        lblReasonA.textProperty().bind(viewSelectedTradeViewModel.getReasonA());
        lblOther.textProperty().bind(viewSelectedTradeViewModel.getOther());
        lblLearn.textProperty().bind(viewSelectedTradeViewModel.getLearn());
    }

}
