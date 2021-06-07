package com.me.demo.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class RequestSizeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int size = servletRequest.getContentLength(); // Get the request size in bytes

        // Check if the size is bigger than 100 bytes, throw an exception
        if (size > 100) {
            throw new ServletException("Response to big");
        }

        // Continue to the next filter
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
