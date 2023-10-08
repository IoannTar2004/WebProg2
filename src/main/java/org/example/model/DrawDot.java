package org.example.model;

public class DrawDot {
    private Point point;

    public DrawDot(Point point) {
        this.point = point;
    }

    public double drawX() {
        double x = 123 + (point.getX() / point.getR()) * 90;
        if (x > 0 && x < 250) {
            return x;
        }
        return -1;
    }

    public double drawY() {
        double y = 124 - (point.getY() / point.getR()) * 90;
        if (y > 0 && y < 250) {
            return y;
        }
        return -1;
    }

    public String color() {
        if (point.getStatus().equals("Попал!")) {
            return "lime";
        }
        return "red";
    }
}

