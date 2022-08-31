/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.tradingjournal;

import ch.bbbaden.tradingjournal.Model.Model;
import ch.bbbaden.tradingjournal.View.AddTrade;
import ch.bbbaden.tradingjournal.View.EditTrade;
import ch.bbbaden.tradingjournal.View.Tradingjournal;
import ch.bbbaden.tradingjournal.View.ViewSelectedTrade;
import ch.bbbaden.tradingjournal.View.ViewTrades;
import ch.bbbaden.tradingjournal.ViewModel.AddTradesViewModel;
import ch.bbbaden.tradingjournal.ViewModel.EditTradeViewModel;
import ch.bbbaden.tradingjournal.ViewModel.TradingjournalViewModel;
import ch.bbbaden.tradingjournal.ViewModel.ViewSelectedTradeViewModel;
import ch.bbbaden.tradingjournal.ViewModel.ViewTradesViewModel;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Dario
 */
public class Main extends Application {

    private Stage stage;
    private final Model model = new Model();
    private final TradingjournalViewModel tradingjournalViewModel = new TradingjournalViewModel(model);
    private final AddTradesViewModel addTradesViewModel = new AddTradesViewModel(model);
    private final ViewTradesViewModel viewTradesViewModel = new ViewTradesViewModel(model);
    private final ViewSelectedTradeViewModel viewSelectedTradeViewModel = new ViewSelectedTradeViewModel(model);
    private final EditTradeViewModel editTradeViewModel = new EditTradeViewModel(model);

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);
        stage.getIcons().add(new Image("/images/trading.jpg"));
        launch("View/Tradingjournal.fxml");

    }

    public void launch(String fxml) throws IOException {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        switch (fxml) {
            case "View/Tradingjournal.fxml": {
                stage.setMaximized(false);
                Tradingjournal view = loader.getController();
                view.setViewModel(tradingjournalViewModel);
                tradingjournalViewModel.setMain(this);
                model.addPropertyChangeListener(tradingjournalViewModel);
                stage.setTitle("Tradingjournal");
                break;
            }
            case "View/AddTrade.fxml": {
                AddTrade view = loader.getController();
                view.setViewModel(addTradesViewModel);
                addTradesViewModel.setMain(this);
                model.addPropertyChangeListener(addTradesViewModel);
                stage.setTitle("Add a Trade");
                view.bind();
                break;
            }
            case "View/ViewTrades.fxml": {
                ViewTrades view = loader.getController();
                view.setViewTradesViewModel(viewTradesViewModel);
                viewTradesViewModel.setMain(this);
                model.addPropertyChangeListener(viewTradesViewModel);
                stage.setTitle("View all Trades");
                view.addItemsToTable();
                break;
            }
            case "View/ViewSelectedTrade.fxml": {
                ViewSelectedTrade view = loader.getController();
                view.setViewSelectedTradeViewModel(viewSelectedTradeViewModel);
                viewSelectedTradeViewModel.setMain(this);
                model.addPropertyChangeListener(viewSelectedTradeViewModel);
                stage.setTitle("View Selected Trade");
                view.bind();
                break;
            }
            default:
                EditTrade view = loader.getController();
                view.setEditTradeViewModel(editTradeViewModel);
                editTradeViewModel.setMain(this);
                model.addPropertyChangeListener(editTradeViewModel);
                stage.setTitle("Edit existing Trade");
                view.oldValues();
                view.bind();
                break;
        }

        scene.getStylesheets().add(getClass().getResource("layout.css").toExternalForm());
        stage.setScene(scene);
        if (!fxml.equals("View/Tradingjournal.fxml")) {
            stage.setMaximized(false);
            stage.setMaximized(true);
        } else {
            stage.centerOnScreen();
        }
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
