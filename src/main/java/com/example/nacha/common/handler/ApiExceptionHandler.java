package com.example.nacha.common.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.example.nacha.common.bean.ApiError;
import com.example.nacha.common.exception.NachaBusinessException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = (ApiError)body;
        
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler({NachaBusinessException.class})
    public ResponseEntity<Object> handleNachaBusinessException(NachaBusinessException ex,
        WebRequest request) {
        ApiError apiError = new ApiError(ex.getError(), ex.getMessage());

        // リクエストヘッダーの作成
        HttpHeaders httpHeaders = new HttpHeaders();

        return handleExceptionInternal(ex, apiError, httpHeaders, HttpStatus.BAD_REQUEST, request);
    }

}
