package com.ahohlov;

import com.ahohlov.config.ConfigurationManager;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExceptionServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("ExceptionServlet init!");
    }

    @Override
    public void destroy() {
        System.out.println("ExceptionServlet destroy!");
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String servletName = (String) request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME);
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        System.out.println("Error information");
        System.out.println("The status code : " + statusCode);
        System.out.println("Servlet Name : " + servletName);
        System.out.println("Exception Type : " + throwable.getClass().getName());
        System.out.println("The request URI: " + requestUri);
        throwable.printStackTrace();

        String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERRORS_PAGE_PATH);
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }
}
