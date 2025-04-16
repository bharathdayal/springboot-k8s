package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(getClass().getName());



    @ExceptionHandler(HandleException.class)
    public ResponseEntity<ApiError> handleException(HandleException except,HttpServletRequest request) {

        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                "Exception occurred"+except.getErrors().toString(),
                "Exception occurred: " + except.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiError> handleNoHandlerFoundException(NoHandlerFoundException except,
                                                                  HttpServletRequest request) {
       //handle handleNoHandlerFoundException
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                "Not Found "+ except.getDetailMessageCode(),
                "Exception occurred: " + except.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        // Handle NullPointerException specifically
        return new ResponseEntity<>("A null pointer error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex,
                                                                          HttpServletRequest request) {
        // Handle HttpMessageNotReadableException specifically
        ApiError error = new ApiError(

                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"+ex.getMessage(),
                "Invalid JSON: " + ex.getMostSpecificCause().getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex
                                                                             ,HttpServletRequest request) {
        String param = ex.getName();
        String expected = ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "unknown";
        // Handle MethodArgumentTypeMismatchException specifically
        ApiError error = new ApiError(

                HttpStatus.BAD_REQUEST.value(),
                "Bad Request"+ ex.getMessage(),
                "Invalid parameter: '" + param + "' must be of type " + expected,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiError> handleMethodNotSupported(HttpRequestMethodNotSupportedException ex
                                                                ,HttpServletRequest request) {
        ApiError error = new ApiError(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "Method Not Allowed"+ex.getMessage(),
                "Use a supported method like: " + ex.getSupportedHttpMethods(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ApiError>> handleFieldValidation(MethodArgumentNotValidException methodExcep
                                                            ,HttpServletRequest request) {
        List<ApiError> errorModelList = new ArrayList<>();
        ApiError errorModel;
        List<FieldError> fieldErrorList = methodExcep.getBindingResult().getFieldErrors();

        for(FieldError fe: fieldErrorList) {
            errorModel = new ApiError(
                    HttpStatus.METHOD_NOT_ALLOWED.value(),
                    fe.getDefaultMessage(),
                    fe.getField(),
                    request.getRequestURI(),
                    LocalDateTime.now());


            //errorModel.setMessage(fe.getDefaultMessage());
            errorModelList.add(errorModel);
        }

        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }
}
