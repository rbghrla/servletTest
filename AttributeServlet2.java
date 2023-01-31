package com.example.servletprojectthirdone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getter")
public class AttributeServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("context:" + getServletContext().getAttribute("context") + "<br/>");
        out.print("session:" + req.getSession().getAttribute("session") + "<br/>");
        out.print("request:" + req.getAttribute("request") + "<br/>");
    }
}
