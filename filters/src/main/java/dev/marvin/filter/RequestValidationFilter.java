package dev.marvin.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class RequestValidationFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RequestValidationFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestId = httpServletRequest.getHeader("Request-Id");

        log.info("Request-Id: {}", requestId);

        if(!StringUtils.hasText(requestId)){
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().print(new ObjectMapper().writeValueAsString("No Request-Id provided"));
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
