package model;

public class Pet {
    private double x, y; // current position
    private double targetX, targetY; // mouse position
    private double speed = 2.0; // pixels per frame

    public Pet(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.targetX = startX;
        this.targetY = startY;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setTargetX(double tx, double ty) {
        this.targetX = tx;
        this.targetY = ty;
    }

    public void moveTowardsTarget(){
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if(distance < speed){
            // close enough, stop at target
            x = targetX;
            y = targetY;
        }
        else{
            //normalise vector and move
            x += (dx / distance) * speed;
            y += (dy / distance) * speed;
        }
    }
}
