package dev.marvin.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class AuthenticationLoggingFilter2 extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationLoggingFilter2.class);

//    @Override
//    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        var requestId = request.getHeader("Request-Id");
//
//        logger.info("Successfully authentication request with Id %s".formatted(requestId));
//
//        chain.doFilter(request, response);
//
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var requestId = request.getHeader("Request-Id");

        logger.info("Successfully authentication request with Id %s".formatted(requestId));
        filterChain.doFilter(request, response);
    }
}
