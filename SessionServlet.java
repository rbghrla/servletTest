package com.example.servletprojectthirdone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        Date date;
        out.print("세션아이디:" + session.getId() + "<br/>");
        out.print("세션생성시각:" + new Date(session.getCreationTime()) + "<br/>");
        out.print("세션유효시간:" + session.getMaxInactiveInterval() + "<br/>");
        out.print("세션마지막접근시간:" + new Date(session.getLastAccessedTime()) + "<br/>");
//      session.setMaxInactiveInterval(5); //세션 유효시간을 5초로 설정
        if (session.isNew()){
            out.print("세션이 최초생성되었음");
        }
    }
}
