package org.example.model;

import java.util.List;

public class PointManager {
    private List<Point> pointList;

    public PointManager(List<Point> pointList) {
        this.pointList = pointList;
    }

    public void check() {
        long startScript = System.nanoTime();
        for (Point point: pointList) {
            double x = point.getX();
            double y = point.getY();
            double r = point.getR();
            if ((x >= 0 && y >= 0 && x <= r && y <= r) || (x < 0 && y < 0 && y + x >= -r/2) || (x > 0 && y < 0 && (x*x + y*y <= r*r))) {
                point.setStatus("Попал!");
            } else {
                point.setStatus("Не попал!");
            }
            long endScript = System.nanoTime();
            point.setScriptTime(endScript - startScript);
        }

    }
}
