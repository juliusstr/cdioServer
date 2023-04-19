package misc.ball;

import misc.Vector2D;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

public class PrimitiveBall {
    public enum Status {
        IN_PLAY,
        COLLECTED,
        DELIVERED,
        GONE,
        IN_ROUTE,
        ROBOT,
        UNKNOWN
    }

    protected int xPos;
    protected int yPos;
    protected Status status;

    public PrimitiveBall(int xPos, int yPos, Status status) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = status;
    }

    public PrimitiveBall(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.status = Status.UNKNOWN;
    }

    public PrimitiveBall(@NotNull Point point, Status status){
        this.xPos = point.x;
        this.yPos = point.y;
        this.status = status;
    }
    public PrimitiveBall(@NotNull Point point){
        this.xPos = point.x;
        this.yPos = point.y;
        this.status = Status.UNKNOWN;
    }

    public PrimitiveBall(@NotNull Vector2D vector, Status status){
        this.xPos = (int) vector.x;
        this.yPos = (int) vector.y;
        this.status = status;
    }
    public PrimitiveBall(@NotNull Vector2D vector){
        this.xPos = (int) vector.x;
        this.yPos = (int) vector.y;
        this.status = Status.UNKNOWN;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public void setPos(Point point){
        xPos = point.x;
        yPos = point.y;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public Point getPoint(){
        return new Point(xPos, yPos);
    }

    public Vector2D getPosVector() {
        return new Vector2D(xPos, yPos);
    }

    @Override
    public String toString() {
        return "PrimitiveBall{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", status=" + status +
                '}';
    }


}
