package org.example.model;

public class Point {
    private int[] x;
    private double y;
    private float r;

    public Point(int[] x, double y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
