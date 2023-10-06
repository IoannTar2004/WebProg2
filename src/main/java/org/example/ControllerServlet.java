package org.example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "hello", urlPatterns = { "/hello" })
public class ControllerServlet extends HttpServlet {



}