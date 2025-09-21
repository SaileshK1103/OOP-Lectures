package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class DictionaryView extends Application {
    private final DictionaryController controller = new DictionaryController();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Virtual Dictionary");

        // Components
        TextField wordInput = new TextField();
        wordInput.setPromptText("Enter a word");

        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        // Action for the button
        searchButton.setOnAction(event -> {
            String word = wordInput.getText();
            String meaning = controller.searchWord(word);
            resultLabel.setText(meaning);
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(wordInput, searchButton, resultLabel);

        Scene scene = new Scene(layout, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
