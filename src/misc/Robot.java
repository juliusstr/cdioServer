package misc;

public class Robot {
    private double xPos,
                yPos;
    private Vector2D directionVector;
    private double  speed,
                    angelSpeed;

    public Robot(double xPos, double yPos, Vector2D directionVector) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.directionVector = directionVector.clone();
        speed = 0;
        angelSpeed = 0;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public Vector2D getDirection() {
        return directionVector;
    }

    public void setDirection(Vector2D directionVector) {
        this.directionVector = directionVector;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getAngelSpeed() {
        return angelSpeed;
    }

    public void setAngelSpeed(double angelSpeed) {
        this.angelSpeed = angelSpeed;
    }
}
