package dev.marvin.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StaticKeyValidationFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(StaticKeyValidationFilter.class);

    @Value("${authorization.secretKey}")
    String serverKey;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String clientKey = httpServletRequest.getHeader("Authorization");
        log.info("server key: {}", serverKey);
        log.info("client key: {}", clientKey);

        if(serverKey.equals(clientKey)){
           filterChain.doFilter(servletRequest,servletResponse);
        }else {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().print(new ObjectMapper().writeValueAsString("Invalid token key"));
        }
    }
}
