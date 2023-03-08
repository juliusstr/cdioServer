package misc;

public class Robot {
    private int xPos,
                yPos;
    private double  direction,
                    speed,
                    angelSpeed;

    public Robot(int xPos, int yPos, double direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
        speed = 0;
        angelSpeed = 0;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
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
