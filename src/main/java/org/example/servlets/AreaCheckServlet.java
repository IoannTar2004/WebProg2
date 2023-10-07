package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.model.Point;
import org.example.model.PointManager;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AreaCheckServlet", value = "/check")
public class AreaCheckServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        List<Point> pointList = (List<Point>) session.getAttribute("allPoints");

        List<Point> newPoints = (List<Point>) req.getAttribute("points");
        PointManager service = new PointManager(newPoints);
        service.check();

        if (pointList != null) pointList.addAll(newPoints);
        else pointList = newPoints;
        session.setAttribute("allPoints", pointList);

        req.setAttribute("points", pointList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req, resp);
    }
}
