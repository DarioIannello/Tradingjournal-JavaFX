/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.View;

import ch.bbbaden.tradingjournal.ViewModel.TradingjournalViewModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Dario
 */
public class Tradingjournal implements Initializable {

    private TradingjournalViewModel tradingjournalViewModel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setViewModel(TradingjournalViewModel tradingjournalViewModel) {
        this.tradingjournalViewModel = tradingjournalViewModel;
    }

    @FXML
    public void switchSceneAdd(ActionEvent event) throws IOException {
        tradingjournalViewModel.switchScene("View/AddTrade.fxml");
    }

    @FXML
    public void switchSceneView(ActionEvent event) throws IOException {
        tradingjournalViewModel.switchScene("View/ViewTrades.fxml");
    }

}
