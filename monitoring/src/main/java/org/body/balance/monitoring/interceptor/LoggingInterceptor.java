package org.body.balance.monitoring.interceptor;

import lombok.extern.log4j.Log4j2;
import org.body.balance.monitoring.utils.MonitoringConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        log.info("GeneralId: {} Request: {} {}", request.getHeader(MonitoringConstants.HEADER_GENERAL_ID), request.getMethod(), request.getRequestURI()); // todo удалить g_id вынести его в общий лог (log4j2.xml)
        return true;  // Allows the request to proceed
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        log.info("GeneralId: {} Response: {} {} {}", request.getHeader(MonitoringConstants.HEADER_GENERAL_ID), response.getStatus(), request.getMethod(), request.getRequestURI()); // todo удалить g_id вынести его в общий лог (log4j2.xml)
        if (ex != null) {
            log.error("Exception: ", ex);
        }
    }
}