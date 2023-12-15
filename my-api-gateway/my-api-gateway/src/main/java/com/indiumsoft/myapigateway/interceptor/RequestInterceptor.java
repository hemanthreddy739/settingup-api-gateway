package com.indiumsoft.myapigateway.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


@Component
public class RequestInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIP = request.getRemoteAddr();
        String method = request.getMethod();
        String url = request.getRequestURI();
        LocalDateTime timestamp = LocalDateTime.now();

        String logMessage = String.format(
                "Client IP: %s | Accessed Method: %s | URL: %s | Timestamp: %s",
                clientIP, method, url, timestamp
        );

        // Log the information into a file
        logToFile(logMessage);

        return true; // Continue with the handler chain
    }

    private void logToFile(String logMessage) {
        String fileName = "clients_log_details.txt";
        File logFile = new File(fileName);

        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            fileWriter.write(logMessage + "\n");
            fileWriter.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}