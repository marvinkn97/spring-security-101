package dev.marvin.csrf.filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import java.io.IOException;

public class CsrfTokenLogger implements Filter {
    private static final Logger log = LoggerFactory.getLogger(CsrfTokenLogger.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        log.info("CSRF Token Header: {}", csrfToken.getHeaderName());
        log.info("CSRF Token Request Param Name: {}", csrfToken.getParameterName());
        log.info("CSRF Token: {}", csrfToken.getToken());

        chain.doFilter(request, response);
    }
}
