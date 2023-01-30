package com.example.servletproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String value = req.getParameter("text");
        String nextAddr = (String) req.getAttribute("nextAttr");
        // 이전 서블릿에서 파라미터로 받았던 값..
        out.print("파라미터로 받았던 value = " + value);
        out.print("<br/>");
        //이전 서블릿에서 애트리뷰트로 바인딩하여 현재 서블릿으로 보내준 값...
        out.print("애트리뷰트로 받은 nextAddr = " + nextAddr);
    }
}
