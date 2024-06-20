package dev.marvin.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;

public class RequestValidationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestId = request.getHeader("Request-Id");

        if(requestId == null || requestId.isBlank()){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return;
        }

        chain.doFilter(request, response);
    }
}
