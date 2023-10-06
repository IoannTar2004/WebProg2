package org.example.model;

import org.example.exceptions.PointValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Validation {
    private JSONObject jsonObject;

    public Validation(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Point validate() throws PointValidationException {
        JSONArray arrayJsonX = jsonObject.getJSONArray("inputX");
        int[] inputX = new int[arrayJsonX.length()];
        for (int i = 0; i < arrayJsonX.length(); i++) {
            int x = arrayJsonX.getInt(i);
            if (x >= -3 & x <= 5) {
                inputX[i] = x;
            } else {
                throw new PointValidationException();
            }
        }

        double y = jsonObject.getDouble("inputY");
        if (y < -3 | y > 3) {
            throw new PointValidationException();
        }

        return new Point(inputX, y, jsonObject.getFloat("inputR"));
    }
}
