package com.example.servletproject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class FirstServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("서블릿 생성");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("First에서 GET 요청");
//        resp.sendRedirect("/second");
//        resp.addHeader("refresh", "3;url=second?name=test");
        RequestDispatcher dispatcher = req.getRequestDispatcher("second");
        dispatcher.forward(req,resp);
    }
//        doHandle(req, resp);
//        Enumeration<String> enumeration = req.getParameterNames();
//            while(enumeration.hasMoreElements()){
//                String name = enumeration.nextElement();
//                String value = req.getParameter(name);
//                System.out.println("request로 받은 name:" + name);
//                System.out.println("request로 받은 value:" + value);

//        String id = req.getParameter("id"); //id 파라미터에 해당하는 값을 가져옴
//        String pw =req.getParameter("pw"); //pw 파라미터에 해당하는 값을 가져옴
//        System.out.println("받은 id값:" + id);
//        System.out.println("받은 pw값:" + pw);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post 요청");
        doHandle(req, resp);

    }

    void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doHandle 요청");
        Enumeration<String> enumeration = req.getParameterNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = req.getParameter(name);
            System.out.println("request로 받은 name:" + name);
            System.out.println("request로 받은 value:" + value);
        }
    }
}
