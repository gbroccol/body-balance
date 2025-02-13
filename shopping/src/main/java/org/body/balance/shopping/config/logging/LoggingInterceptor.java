
package org.body.balance.shopping.config.logging;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@Component
public class LoggingInterceptor implements HandlerInterceptor { // todo вынести в стартер + конфигурацию кафки

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String generalId = request.getHeader(MonitoringConstants.HEADER_GENERAL_ID);

        if (StringUtils.isEmpty(generalId)) generalId = getUuid();

        request.setAttribute(MonitoringConstants.HEADER_GENERAL_ID, generalId);
        response.setHeader(MonitoringConstants.HEADER_GENERAL_ID, generalId);

        log.info("GeneralId: {}, Request Method: {}, Request URI: {}", generalId, request.getMethod(), request.getRequestURI());

        return true;  // Allows the request to proceed
    }

    private String getUuid() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws IOException {


        if (ex == null) {
            log.error("GeneralId: {} Response: {} {} {}",
                    response.getHeader(MonitoringConstants.HEADER_GENERAL_ID),
                    response.getStatus(),
                    request.getMethod(),
                    request.getRequestURI());
        } else {
            log.info("GeneralId: {} Response: {} {} {} Exception: {}",
                    response.getHeader(MonitoringConstants.HEADER_GENERAL_ID),
                    response.getStatus(),
                    request.getMethod(),
                    request.getRequestURI(),
                    ex);
        }
    }
}