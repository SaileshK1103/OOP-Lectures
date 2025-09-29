package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CurrencyApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/currencyView.fxml"));
        Scene scene = new Scene(loader.load(), 400, 300);
        stage.setTitle("Database-Enhanced Currency Converter");
        stage.setScene(scene);
        stage.show();
    }
}
