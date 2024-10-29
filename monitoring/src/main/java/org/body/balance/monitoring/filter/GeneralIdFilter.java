package org.body.balance.monitoring.filter;

import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.UUID;

@Component
public class GeneralIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        if (httpServletRequest.getHeader("g_id") == null) {
            String generatedGId = UUID.randomUUID().toString();
            HttpServletRequest wrappedRequest = new GIdRequestWrapper(httpServletRequest, generatedGId);
            chain.doFilter(wrappedRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    private static class GIdRequestWrapper extends HttpServletRequestWrapper {
        private final String gIdValue;

        public GIdRequestWrapper(HttpServletRequest request, String gIdValue) {
            super(request);
            this.gIdValue = gIdValue;
        }

        @Override
        public String getHeader(String name) {
            if ("g_id".equalsIgnoreCase(name)) {
                return gIdValue;
            }
            return super.getHeader(name);
        }
    }
}