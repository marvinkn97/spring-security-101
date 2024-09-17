package dev.marvin.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HelloFilter extends HttpFilter {
    private static final Logger log = LoggerFactory.getLogger(HelloFilter.class);
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
       log.info("Inside the HelloFilter before Basic Auth Filter");
       request.setAttribute("hello", "saying hello from Hello Filter");
       response.getWriter().println("Said Hello");
       chain.doFilter(request, response);
    }
}
