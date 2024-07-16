package dev.marvin.filter;

import jakarta.servlet.*;

import java.io.IOException;


//how to create a filter/interceptor by implementing Filter Interface
public class CustomerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
