/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.View;

import ch.bbbaden.tradingjournal.ViewModel.EditTradeViewModel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dario
 */
public class EditTrade implements Initializable {

    private String oldPair;
    private String oldBs;
    private String oldWbel;
    private String oldStrat;
    private String oldProfit;
    private String oldReasonsF;
    private String oldReasonsA;
    private String oldOthers;
    private String oldLearn;

    private EditTradeViewModel editTradeViewModel;
    @FXML
    private TextField txtPair;
    @FXML
    private ChoiceBox<String> cbBS;
    @FXML
    private DatePicker dp;
    @FXML
    private TextField txtTime;
    @FXML
    private ChoiceBox<String> cbWBEL;
    @FXML
    private ChoiceBox<String> cbStrat;
    @FXML
    private TextField txtProfit;
    @FXML
    private TextField txtReasonsF;
    @FXML
    private TextField txtReasonsA;
    @FXML
    private TextField txtOthers;
    @FXML
    private TextField txtLearn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbBS.getItems().add("BUY");
        cbBS.getItems().add("SELL");
        cbBS.setValue("BUY");
        cbWBEL.getItems().add("WIN");
        cbWBEL.getItems().add("BE");
        cbWBEL.getItems().add("LOSS");
        cbWBEL.setValue("WIN");
        cbStrat.getItems().add("TBX");
        cbStrat.getItems().add("Harmonics");
        cbStrat.getItems().add("Pricetrap");
        cbStrat.getItems().add("ECC-11");
        cbStrat.getItems().add("Steady");
        cbStrat.getItems().add("Colors");
        cbStrat.setValue("TBX");
        dp.setValue(LocalDate.now());
    }

    public void setEditTradeViewModel(EditTradeViewModel editTradeViewModel) {
        this.editTradeViewModel = editTradeViewModel;
    }

    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        editTradeViewModel.update(txtPair.getText(), cbBS.getValue(), dp.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), txtTime.getText(), cbWBEL.getValue(), cbStrat.getValue(), txtProfit.getText(), txtReasonsF.getText(), txtReasonsA.getText(), txtOthers.getText(), txtLearn.getText());
        editTradeViewModel.switchScene("View/ViewTrades.fxml");
    }

    public void bind() {
        txtPair.textProperty().bindBidirectional(editTradeViewModel.getPair());
        txtTime.textProperty().bindBidirectional(editTradeViewModel.getTime());
        txtProfit.textProperty().bindBidirectional(editTradeViewModel.getProfit());
        txtReasonsF.textProperty().bindBidirectional(editTradeViewModel.getReasonF());
        txtReasonsA.textProperty().bindBidirectional(editTradeViewModel.getReasonA());
        txtOthers.textProperty().bindBidirectional(editTradeViewModel.getOther());
        txtLearn.textProperty().bindBidirectional(editTradeViewModel.getLearn());
    }

    public void oldValues() {
        oldPair = editTradeViewModel.getPair().getValue();
        oldProfit = editTradeViewModel.getProfit().getValue();
        oldReasonsF = editTradeViewModel.getReasonF().getValue();
        oldReasonsA = editTradeViewModel.getReasonA().getValue();
        oldOthers = editTradeViewModel.getOther().getValue();
        oldLearn = editTradeViewModel.getLearn().getValue();
    }
}
