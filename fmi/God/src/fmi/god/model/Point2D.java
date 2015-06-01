package fmi.god.model;

public class Point2D {

    public final static double MAX_Y = 10000.0;

    public final static double MAX_X = 10000.0;

    private double x;

    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Double distance(Point2D second) {
        if (this == null || second == null) {
            return null;
        }

        double xDiff = this.getX() - second.getX();
        double yDiff = this.getY() - second.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    @Override
    public String toString() {
        return "[ x: " + x + ", y: " + y + "]";
    }

}
