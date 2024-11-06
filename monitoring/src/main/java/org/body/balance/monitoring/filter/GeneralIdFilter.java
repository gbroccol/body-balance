package org.body.balance.monitoring.filter;

import org.body.balance.monitoring.utils.MonitoringConstants;
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
        String headerValue = httpServletRequest.getHeader(MonitoringConstants.HEADER_GENERAL_ID);

        if (headerValue == null || headerValue.isEmpty()) {
            String newGeneralId = getUuid();
            HttpServletRequest wrappedRequest = new GeneralIdRequestWrapper(httpServletRequest, newGeneralId);
            chain.doFilter(wrappedRequest, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    private static class GeneralIdRequestWrapper extends HttpServletRequestWrapper {
        private final String generalId;

        public GeneralIdRequestWrapper(HttpServletRequest request, String generalId) {
            super(request);
            this.generalId = generalId;
        }

        @Override
        public String getHeader(String name) {
            if (MonitoringConstants.HEADER_GENERAL_ID.equalsIgnoreCase(name)) {
                return generalId;
            }
            return super.getHeader(name);
        }
    }
}