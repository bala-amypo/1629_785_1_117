package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Simple status check servlet - does not affect testcases.
 * Accessible at: http://localhost:8080/status
 */

@WebServlet(urlPatterns = "/status")
public class SimpleStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/plain");
        resp.getWriter().write("Server Running Successfully");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
