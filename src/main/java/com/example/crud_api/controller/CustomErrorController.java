package com.example.crud_api.controller;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(WebRequest request) {
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(
                request, ErrorAttributeOptions.defaults()
        );

        HttpStatus status = HttpStatus.valueOf((Integer) errorDetails.get("status"));

        return new ResponseEntity<>(Map.of(
                "error", errorDetails.get("error"),
                "message", errorDetails.get("message"),
                "status", errorDetails.get("status"),
                "path", errorDetails.get("path")
        ), status);
    }
}
