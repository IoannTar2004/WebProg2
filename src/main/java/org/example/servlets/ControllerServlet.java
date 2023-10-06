package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exceptions.PointValidationException;
import org.example.model.Point;
import org.example.model.Validation;
import org.json.JSONObject;

@WebServlet(name = "controller", urlPatterns = { "/controller" })
public class ControllerServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        Validation validation = new Validation(new JSONObject(req.getParameter("data")));
        try {
            Point point = validation.validate();
            RequestDispatcher dispatcher = req.getRequestDispatcher("")
        } catch (PointValidationException e) {
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