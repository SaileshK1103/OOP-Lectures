package view;

import controller.NoteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.NoteBook;

import java.io.IOException;

public class NoteApp extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            // Instantiate the model and controller
            NoteBook notebook = new NoteBook();
            NoteController appController = new NoteController(notebook);

            // Load the fxml view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/NoteView.fxml"));
            Parent root = loader.load();

            // Inject the controller into the view controller
            // Get the fxml's controller instance
            NoteViewController viewController = loader.getController();

            // Pass the application's NoteController instance to the View Controller
            viewController.setController(appController);

            // Set up the Stage and Scene
            Scene scene = new Scene(root);
            primaryStage.setTitle("Personal Notebook");
            primaryStage.setScene(scene);
            primaryStage.setMinHeight(400);
            primaryStage.setMinWidth(650);
            primaryStage.show();
        }
        catch (IOException e){
            System.err.println("Error loading FXML file: NoteView.fxml");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
