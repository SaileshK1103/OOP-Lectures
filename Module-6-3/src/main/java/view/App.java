package view;

import controller.PetController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Pet;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Pet pet = new Pet(200, 200);
        PetView petView = new PetView(stage,pet, null);

        PetController controller = new PetController(pet, petView);

        petView.setController(controller);
    }

}
