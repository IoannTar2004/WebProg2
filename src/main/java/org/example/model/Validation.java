package org.example.model;

import jakarta.servlet.http.HttpServletRequest;
import org.example.exceptions.PointValidationException;

import java.util.LinkedList;
import java.util.List;

public class Validation {
    private final HttpServletRequest request;

    public Validation(HttpServletRequest request) {
        this.request = request;
    }

    public List<Point> validate() throws PointValidationException {
        List<Integer> list = arrayParse();
        List<Point> pointList = new LinkedList<>();

        double y = Double.parseDouble(request.getParameter("inputY"));
        double r = Double.parseDouble(request.getParameter("inputR"));
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if (x >= -5 & x <= 3 & y >= -5 & y <= 3 & r >= 2 & r <= 5) {
                pointList.add(new Point(x, y, r));
            } else {
                throw new PointValidationException();
            }
        }
        return pointList;
    }

    private List<Integer> arrayParse() {
        List<Integer> list = new LinkedList<>();
        for(int i = -5; i <= 3; i++) {
            if (request.getParameter(String.format("checkbox(%d)", i)) != null) {
                int x = Integer.parseInt(request.getParameter(String.format("checkbox(%d)", i)));
                list.add(x);
            }
        }
        return list;
    }
}
