/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.ViewModel;

import ch.bbbaden.tradingjournal.Entity.Trades;
import ch.bbbaden.tradingjournal.Model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 *
 * @author Dario
 */
public class ViewTradesViewModel extends ViewModel implements PropertyChangeListener {

    private final Model model;

    public ViewTradesViewModel(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }

    public void switchScene(String fxml) throws IOException {
        main.launch(fxml);
    }

    public void viewTradeInDetail(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        model.viewTradeInDetail(pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
    }
    public void updateOldValues(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        model.updateOldValues(pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
    }

    public ObservableList<Trades> getListFromModel() {
        return model.getTrades();
    }

}
