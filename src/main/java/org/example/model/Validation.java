package org.example.model;

import org.example.exceptions.PointValidationException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Validation {
    private JSONObject jsonObject;


    public Validation(String json) {
        this.jsonObject = new JSONObject(json);
    }

    public List<Point> validate() throws PointValidationException {
        try {
            List<Double> list = arrayParse();
            List<Point> pointList = new LinkedList<>();

            if (list.size() == 0 | jsonObject.get("inputY") == null | jsonObject.get("inputR") == null) {
                throw new PointValidationException();
            }
            double y = Double.parseDouble(String.valueOf(jsonObject.get("inputY")));
            double r = Double.parseDouble(String.valueOf(jsonObject.get("inputR")));

            for (int i = 0; i < list.size(); i++) {
                double x = list.get(i);
                if (x >= -5 & x <= 3 & y >= -5 & y <= 3 & r >= 2 & r <= 5) {
                    pointList.add(new Point(x, y, r));
                } else {
                    throw new PointValidationException();
                }
            }
            return pointList;
        } catch (PointValidationException | JSONException e) {
            throw new PointValidationException();
        }
    }

    private List<Double> arrayParse() {
        JSONArray arrayX = jsonObject.getJSONArray("inputX");

        List<Double> list = new LinkedList<>();
        for(int i = 0; i < arrayX.length(); i++) {
            list.add(Double.parseDouble(String.valueOf(arrayX.get(i))));
        }
        return list;
    }
}
