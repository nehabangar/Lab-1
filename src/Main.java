import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the CurrencyConverter.fxml file using FXMLLoader
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Conversion.fxml"));
        AnchorPane root = loader.load();

        // Get the controller instance from the FXMLLoader (not used in the original code)

        // Create a new scene with the root node
        Scene scene = new Scene(root);

        // Set the scene for the primary stage
        primaryStage.setScene(scene);

        // Set the title of the stage
        primaryStage.setTitle("Currency Converter");

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

}