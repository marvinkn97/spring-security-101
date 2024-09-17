package dev.marvin.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AuthenticationLoggingFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String requestId = httpServletRequest.getHeader("Request-Id");
        log.info("Request-Id: {}", requestId);
        log.info("Successfully authenticated request with id: {}", requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
