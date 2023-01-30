package com.example.servletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/getcookie")
public class getCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("test/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie[] allCookies = req.getCookies();
        for (Cookie cookie : allCookies){
            out.print("내가 가져온 쿠키이름:" + cookie.getName());
            out.print("<br/");
            out.print("내가 가져온 쿠키값: " + URLDecoder.decode(cookie.getValue(), "utf-8"));
            out.print("<br/");
        }
    }
}
