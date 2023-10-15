package org.example.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exceptions.PointValidationException;
import org.example.model.Point;
import org.example.model.Validation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentTime", new SimpleDateFormat("dd-M-yyyy kk:mm:ss").format(new Date()));
        try {
            Validation validation = new Validation(req.getParameter("data"));
            List<Point> pointList = validation.validate();
            req.setAttribute("points", pointList);
            req.setAttribute("error", false);
        } catch (PointValidationException e) {
            req.setAttribute("error", true);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/check");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}