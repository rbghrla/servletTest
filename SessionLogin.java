package com.example.servletprojectthirdone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/slogin")
public class SessionLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHandle(req, resp);

    }
    protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String id = req.getParameter("id");

        if(id == null || session.isNew()){
            if (id.equals("")){
                out.print("id를 입력 하세요!");
                out.print("<a href='/login.html'>로그인창으로</a>");
                session.invalidate();
            }
            else{
                session.setAttribute("id", id);
                out.print("환영합니다" + session.getAttribute("id") + "님 <br/>");
                out.print("<a href='/logout'>로그아웃</a>");
            }
        }
        else {
            out.print("환영합니다" + session.getAttribute("id") + "님 <br/>");
        }
    }
}
