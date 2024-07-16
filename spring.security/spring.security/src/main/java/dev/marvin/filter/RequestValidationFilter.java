package dev.marvin.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestValidationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String requestId = request.getHeader("Request-Id");

        Map<String, Object> map = new HashMap<>();

        if(requestId == null || requestId.isBlank()){
            map.put("ERROR_CODE", HttpStatus.BAD_REQUEST.value());
            map.put("ERROR", HttpStatus.BAD_REQUEST.getReasonPhrase());
            map.put("MESSAGE", "No Request Id provided");

            String jsonData = new ObjectMapper().writeValueAsString(map);

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().println(jsonData);

            return;
        }

        chain.doFilter(request, response);
    }
}
