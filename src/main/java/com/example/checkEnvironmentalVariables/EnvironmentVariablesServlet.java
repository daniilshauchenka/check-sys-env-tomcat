package com.example.checkEnvironmentalVariables;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


@WebServlet("/checkenv")
public class EnvironmentVariablesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> env = new TreeMap<>(System.getenv());
        List<String> variablesList = new ArrayList<>();

//        for (Map.Entry<String, String> entry : env.entrySet()) {
//            variablesList.add(entry.getKey() + " : " + entry.getValue());
//        }

        Properties properties = System.getProperties();
        TreeMap<Object, Object> sortedProperties = new TreeMap<>(properties);
        for (Map.Entry<Object, Object> entry : sortedProperties.entrySet()) {
            variablesList.add(entry.getKey().toString() + " : " + entry.getValue().toString());
        }
        
        request.setAttribute("variablesList", variablesList);
        request.getRequestDispatcher("envlist.jsp").forward(request, response);
    }
}