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

/**
 *
 * @author Dario
 */
public class TradingjournalViewModel extends ViewModel implements PropertyChangeListener {

    private final Model model;

    public TradingjournalViewModel(Model model) {
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        
    }

    public void switchScene(String fxml) throws IOException {
        main.launch(fxml);
    }

}
