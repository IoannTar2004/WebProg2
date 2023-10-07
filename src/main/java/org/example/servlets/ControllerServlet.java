package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exceptions.PointValidationException;
import org.example.model.Point;
import org.example.model.Validation;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/controller" })
public class ControllerServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("currentTime", new SimpleDateFormat("dd-M-yyyy kk:mm:ss").format(new Date()));
        try {
            Validation validation = new Validation(req);
            List<Point> pointList = validation.validate();
            req.setAttribute("points", pointList);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/check");
            dispatcher.forward(req, resp);
        } catch (PointValidationException e) {
            throw new RuntimeException(e);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

}