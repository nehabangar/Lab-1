import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ConversionController {
    @FXML
    private TextField amountTextField;
    @FXML
    private ComboBox<String> sourceCurrencyComboBox;
    @FXML
    private ComboBox<String> targetCurrencyComboBox;
    @FXML
    private Button convertButton;
    @FXML
    private TextField convertedAmountTextField;

    // Conversion rates from USD to other currencies
    private static final double USD_TO_EGP = 30.85;
    private static final double USD_TO_YEN = 136.99;
    private static final double USD_TO_CAD = 1.35;
    private static final double USD_TO_CUP = 24.0;
    private static final double USD_TO_ARS = 231.60;

    @FXML
    private void initialize() {
        // Populate the source and target currency combo boxes
        sourceCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "CAD", "CUP", "ARS");
        targetCurrencyComboBox.getItems().addAll("USD", "EGP", "YEN", "CAD", "CUP", "ARS");
    }

    @FXML
    private void handleConvertButtonClicked() {
        // Get the selected source and target currencies
        String sourceCurrency = sourceCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        if (sourceCurrency != null && targetCurrency != null) {
            // Parse the amount to be converted
            double amount = Double.parseDouble(amountTextField.getText());

            double convertedAmount;
            if (sourceCurrency.equals("USD")) {
                // Conversion from USD to non-USD currency
                convertedAmount = convertUSDtoNonUSD(amount, targetCurrency);
            } else if (targetCurrency.equals("USD")) {
                // Conversion from non-USD to USD currency
                convertedAmount = convertNonUSDToUSD(amount, sourceCurrency);
            } else {
                // Conversion between two non-USD currencies
                double amountInUSD = convertNonUSDToUSD(amount, sourceCurrency);
                convertedAmount = convertUSDtoNonUSD(amountInUSD, targetCurrency);
            }

            // Set the converted amount in the text field
            convertedAmountTextField.setText(String.valueOf(convertedAmount));
        }
    }

    // Convert amount from USD to the specified non-USD currency
    private double convertUSDtoNonUSD(double amount, String targetCurrency) {
        return switch (targetCurrency) {
            case "EGP" -> amount * USD_TO_EGP;
            case "YEN" -> amount * USD_TO_YEN;
            case "CAD" -> amount * USD_TO_CAD;
            case "CUP" -> amount * USD_TO_CUP;
            case "ARS" -> amount * USD_TO_ARS;
            default -> amount;
        };
    }

    // Convert amount from the specified non-USD currency to USD
    private double convertNonUSDToUSD(double amount, String sourceCurrency) {
        return switch (sourceCurrency) {
            case "EGP" -> amount / USD_TO_EGP;
            case "YEN" -> amount / USD_TO_YEN;
            case "CAD" -> amount / USD_TO_CAD;
            case "CUP" -> amount / USD_TO_CUP;
            case "ARS" -> amount / USD_TO_ARS;
            default -> amount;
        };
    }
}