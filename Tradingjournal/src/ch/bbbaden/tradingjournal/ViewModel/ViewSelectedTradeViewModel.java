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
public class ViewSelectedTradeViewModel extends ViewModel implements PropertyChangeListener {

    private final Model model;

    private final StringProperty pair = new SimpleStringProperty("");
    private final StringProperty bs = new SimpleStringProperty("");
    private final StringProperty date = new SimpleStringProperty("");
    private final StringProperty time = new SimpleStringProperty("");
    private final StringProperty wbel = new SimpleStringProperty("");
    private final StringProperty strat = new SimpleStringProperty("");
    private final StringProperty profit = new SimpleStringProperty("");
    private final StringProperty reasonF = new SimpleStringProperty("");
    private final StringProperty reasonA = new SimpleStringProperty("");
    private final StringProperty other = new SimpleStringProperty("");
    private final StringProperty learn = new SimpleStringProperty("");

    public ViewSelectedTradeViewModel(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        switch (pce.getPropertyName()) {
            case "pair":
                pair.setValue(pce.getNewValue().toString());
                break;
            case "bs":
                bs.setValue(pce.getNewValue().toString());
                break;
            case "date":
                date.setValue(pce.getNewValue().toString());
                break;
            case "time":
                time.setValue(pce.getNewValue().toString());
                break;
            case "wbel":
                wbel.setValue(pce.getNewValue().toString());
                break;
            case "strat":
                strat.setValue(pce.getNewValue().toString());
                break;
            case "profit":
                profit.setValue(pce.getNewValue().toString());
                break;
            case "reasonF":
                reasonF.setValue(pce.getNewValue().toString());
                break;
            case "reasonA":
                reasonA.setValue(pce.getNewValue().toString());
                break;
            case "other":
                other.setValue(pce.getNewValue().toString());
                break;
            case "learn":
                learn.setValue(pce.getNewValue().toString());
                break;
            default:
                break;
        }
    }

    public void switchScene(String fxml) throws IOException {
        main.launch(fxml);
    }

    public StringProperty getPair() {
        return pair;
    }

    public StringProperty getBs() {
        return bs;
    }

    public StringProperty getDate() {
        return date;
    }

    public StringProperty getTime() {
        return time;
    }

    public StringProperty getWbel() {
        return wbel;
    }

    public StringProperty getStrat() {
        return strat;
    }

    public StringProperty getProfit() {
        return profit;
    }

    public StringProperty getReasonF() {
        return reasonF;
    }

    public StringProperty getReasonA() {
        return reasonA;
    }

    public StringProperty getOther() {
        return other;
    }

    public StringProperty getLearn() {
        return learn;
    }
}
