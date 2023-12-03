package com.example.checkEnvironmentalVariables;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@WebServlet("/checkenv")
public class EnvironmentVariablesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> env = new TreeMap<>(System.getenv());
        List<String> variablesList = new ArrayList<>();

        for (Map.Entry<String, String> entry : env.entrySet()) {
            variablesList.add(entry.getKey() + " : " + entry.getValue());
        }
System.out.println(variablesList);
        request.setAttribute("variablesList", variablesList);
        request.getRequestDispatcher("envlist.jsp").forward(request, response);
    }
}