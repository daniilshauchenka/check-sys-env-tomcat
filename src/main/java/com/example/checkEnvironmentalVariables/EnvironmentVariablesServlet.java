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
        List<String> envList = new ArrayList<>();
        List<String> propertiesList = new ArrayList<>();

        for (Map.Entry<String, String> entry : env.entrySet()) {
            envList.add(entry.getKey() + " : " + entry.getValue());
        }

        Properties properties = System.getProperties();
        TreeMap<Object, Object> sortedProperties = new TreeMap<>(properties);
        for (Map.Entry<Object, Object> entry : sortedProperties.entrySet()) {
            propertiesList.add(entry.getKey().toString() + " : " + entry.getValue().toString());
        }
        request.setAttribute("envList", envList);
        request.setAttribute("propertiesList", propertiesList);
        request.getRequestDispatcher("envlist.jsp").forward(request, response);
    }
}