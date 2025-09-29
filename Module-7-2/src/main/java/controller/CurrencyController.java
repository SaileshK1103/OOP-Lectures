package controller;

import dao.CurrencyDao;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyController {
    @FXML
    private TextField fromCurrency;

    @FXML
    private TextField toCurrency;

    @FXML
    private TextField amountField;

    @FXML
    private Label resultLabel;

    private CurrencyDao currencyDao = new CurrencyDao();

    @FXML
    private void handleConvert() {
        try {
            String fromAbbr = fromCurrency.getText().trim().toUpperCase();
            String toAbbr = toCurrency.getText().trim().toUpperCase();
            double amount = Double.parseDouble(amountField.getText().trim());

            double fromRate = currencyDao.getRateByAbbreviation(fromAbbr);
            double toRate = currencyDao.getRateByAbbreviation(toAbbr);

            if (fromRate == -1 || toRate == -1) {
                resultLabel.setText("Error: Currency not found in DB!");
                return;
            }

            double converted = amount * (toRate / fromRate);
            resultLabel.setText(amount + " " + fromAbbr + " = " + converted + " " + toAbbr);

        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid amount!");
        } catch (Exception e) {
            resultLabel.setText("DB Error: " + e.getMessage());
        }
    }
}
