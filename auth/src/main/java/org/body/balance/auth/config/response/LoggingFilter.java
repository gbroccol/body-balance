package org.body.balance.auth.config.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Log4j2
@Component
public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        CustomResponseWrapper responseWrapper = new CustomResponseWrapper((HttpServletResponse) response);

        try {
            chain.doFilter(httpRequest, responseWrapper);
        } catch (Exception ex) {

            responseWrapper.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseWrapper.setContentType("application/json;charset=UTF-8");

            List<ErrorResponse> errors = List.of(new ErrorResponse("Internal Server Error", ex.getCause().getMessage(), "An unexpected error occurred"));

            ObjectMapper objectMapper = new ObjectMapper();
            responseWrapper.getWriter().write(objectMapper.writeValueAsString(Map.of("errors", errors)));
            responseWrapper.getWriter().flush();
        }

        response.getOutputStream().write(responseWrapper.getCapturedData());
    }
}