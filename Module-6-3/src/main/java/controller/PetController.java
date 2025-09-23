package controller;

import javafx.animation.AnimationTimer;
import model.Pet;
import view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;
    private boolean active;

    private AnimationTimer timer;

    public PetController(Pet pet, PetView view) {
        this.pet = pet;
        this.view = view;

        // Time starts immediately, but with a valid view reference
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (active) {
                    pet.moveTowardsTarget();
                    view.drawPet();
                }
            }
        };
        timer.start(); // Start the timer here
    }

    public void setView(PetView view) {
        this.view = view;
    }

    public void setTarget(double x, double y) {
        pet.setTargetX(x, y);
        active = true;
    }

    public void stop() {
        active = false;
    }
}
