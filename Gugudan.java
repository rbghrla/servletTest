package com.example.servletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/gugu")
public class Gugudan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            int dan = Integer.parseInt(req.getParameter("dan"));
            out.print("<h1>" + dan + "단 구구단 </h1>");
            for (int i = 1; i < 10; i++) {
                out.print("<table border = \"1\">\n" +
                          "<tr>\n" +
                          "<td>" + dan + "</td>\n" +
                          "<td>" + i + "</td>" +
                          "<td>" + dan * i + "</td>" +
                          "</td>\n" +
                          "</tr>");
            }
            out.print("</table>");
        }
        catch (Exception e){
            out.print("숫자만 입력해 주세요!!!!");
        }

    }
}
