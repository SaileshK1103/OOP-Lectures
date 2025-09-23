package view;

import controller.PetController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;

public class PetView{
    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;
    private Pet pet;
    private PetController controller;

    public PetView(Stage stage, Pet pet, PetController controller) {
        this.pet = pet;
        this.controller = controller;

        canvas = new Canvas(600, 400);
        gc = canvas.getGraphicsContext2D();

        // Loading pet image
        try {
            petImage = new Image("pet.png", 50, 50, true, true);
        }
        catch (Exception e) {
            System.err.println("Couldnot load image: pet.png");
            e.printStackTrace();
        }

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Virtual Pet");
        stage.show();

        // Draw first time
        drawPet();
    }

    // Prove reference to the PetController
    public void setController(PetController controller) {
        this.controller = controller;
        // Mouse movement
        canvas.setOnMouseMoved(event ->  this.controller.setTarget(event.getX(), event.getY()));
        canvas.setOnMouseExited(event -> this.controller.stop());
    }

    public void drawPet() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if(petImage != null){
            gc.drawImage(petImage, pet.getX(), pet.getY());
        }
    }
}
