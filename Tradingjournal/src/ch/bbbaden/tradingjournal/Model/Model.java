/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal.Model;

import ch.bbbaden.tradingjournal.Entity.Database;
import ch.bbbaden.tradingjournal.Entity.Trades;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.collections.ObservableList;

/**
 *
 * @author Dario
 */
public class Model {

    String pair;
    String bs;
    String date;
    String time;
    String wbel;
    String strat;
    String profit;
    String reasonsF;
    String reasonsA;
    String others;
    String learn;

    Database database = new Database();

    protected final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public void addInputsToDatabase(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        database.insert(pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
    }

    public void update(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        database.update(this.pair, this.bs, this.date, this.time, this.wbel, this.strat, this.profit, this.reasonsF, this.reasonsA, this.others, this.learn, pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
    }

    public void viewTradeInDetail(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        changes.firePropertyChange("pair", null, pair);
        changes.firePropertyChange("bs", null, bs);
        changes.firePropertyChange("date", null, date);
        changes.firePropertyChange("time", null, time);
        changes.firePropertyChange("wbel", null, wbel);
        changes.firePropertyChange("strat", null, strat);
        changes.firePropertyChange("profit", null, profit);
        changes.firePropertyChange("reasonF", null, reasonsF);
        changes.firePropertyChange("reasonA", null, reasonsA);
        changes.firePropertyChange("other", null, others);
        changes.firePropertyChange("learn", null, learn);
    }

    public void updateOldValues(String pair, String bs, String date, String time, String wbel, String strat, String profit, String reasonsF, String reasonsA, String others, String learn) {
        viewTradeInDetail(pair, bs, date, time, wbel, strat, profit, reasonsF, reasonsA, others, learn);
        this.pair = pair;
        this.bs = bs;
        this.date = date;
        this.time = time;
        this.wbel = wbel;
        this.strat = strat;
        this.profit = profit;
        this.reasonsF = reasonsF;
        this.reasonsA = reasonsA;
        this.others = others;
        this.learn = learn;
    }

    public ObservableList<Trades> getTrades() {
        return database.select();
    }
}
