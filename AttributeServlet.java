package com.example.servletprojectthirdone;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setter")
public class AttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String contexts = "context에 바인딩";
        String sessiontexts = "session에 바인딩";
        String requesttexts = "request에 바인딩";

        ServletContext context = getServletContext();
        HttpSession session = req.getSession();

        context.setAttribute("context", contexts);
        context.setAttribute("session", sessiontexts);
        context.setAttribute("request", requesttexts);

    }
}
