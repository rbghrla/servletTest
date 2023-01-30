package com.example.servletproject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("number", 100);


        InputStream inputStream = servletContext.getResourceAsStream("/text.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String datas = bufferedReader.readLine();
        String readDatas = "";
        while (datas != null){
            readDatas += datas;
            datas = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStream.close();

        servletContext.setAttribute("readData", readDatas);
    }
}
