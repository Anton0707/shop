package com.ahohlov.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void destroy() {
        System.out.println("LogFilter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(
                "#INFO " + new Date() + " URL =" + req.getRequestURL() + (req.getQueryString() == null ? "" : "?" + req.getQueryString())
        );
        chain.doFilter(request, response);
    }

}
