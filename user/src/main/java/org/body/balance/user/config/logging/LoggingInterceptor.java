package org.body.balance.user.config.logging;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Log4j2
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String generalId = request.getHeader(MonitoringConstants.HEADER_GENERAL_ID);

        if (StringUtils.isEmpty(generalId)) generalId = getUuid();

        request.setAttribute(MonitoringConstants.HEADER_GENERAL_ID, generalId);
        response.setHeader(MonitoringConstants.HEADER_GENERAL_ID, generalId);

        log.info("GeneralId: {} Request: {} {}", generalId, request.getMethod(), request.getRequestURI());
        return true;  // Allows the request to proceed
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        String generalId = response.getHeader(MonitoringConstants.HEADER_GENERAL_ID);
        log.info("GeneralId: {} Response: {} {} {}", generalId, response.getStatus(), request.getMethod(), request.getRequestURI());
        if (ex != null) {
            log.error("Exception: ", ex);
        }
    }
}