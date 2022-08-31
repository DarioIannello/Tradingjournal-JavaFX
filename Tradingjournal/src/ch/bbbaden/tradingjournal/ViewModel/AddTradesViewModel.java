/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.ViewModel;

import ch.bbbaden.tradingjournal.Model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Dario
 */
public class AddTradesViewModel extends ViewModel implements PropertyChangeListener {

    private final Model model;
    private final StringProperty pair = new SimpleStringProperty("");
    private final StringProperty time = new SimpleStringProperty("");
    private final StringProperty profit = new SimpleStringProperty("");
    private final StringProperty reasonsF = new SimpleStringProperty("");
    private final StringProperty reasonsA = new SimpleStringProperty("");
    private final StringProperty others = new SimpleStringProperty("");
    private final StringProperty learn = new SimpleStringProperty("");

    public AddTradesViewModel(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }

    public void switchScene(String fxml) throws IOException {
        pair.setValue("");
        time.setValue("");
        profit.setValue("");
        reasonsF.setValue("");
        reasonsA.setValue("");
        others.setValue("");
        learn.setValue("");
        main.launch(fxml);
    }

    public StringProperty getPair() {
        return pair;
    }

    public StringProperty getTime() {
        return time;
    }

    public StringProperty getProfit() {
        return profit;
    }

    public StringProperty getReasonsF() {
        return reasonsF;
    }

    public StringProperty getReasonsA() {
        return reasonsA;
    }

    public StringProperty getOthers() {
        return others;
    }

    public StringProperty getLearn() {
        return learn;
    }

    public void addInputsToDatabase(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        model.addInputsToDatabase(pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
    }
}
