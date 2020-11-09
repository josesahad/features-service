package org.jsahad.api.handler;

import org.jsahad.model.exception.FeatureNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Exception handler that converts thrown exceptions to readable error responses.
 */
@RestControllerAdvice
class RestExceptionHandler {

    /**
     * Handles {@link FeatureNotFoundException}
     * 
     * @param request http request.
     * @param exception FeatureNotFoundException.
     * @return {@link RestError} class with the corresponding error information.
     */
    @ExceptionHandler(FeatureNotFoundException.class)
    public ResponseEntity<RestError> handleFeatureNotFoundException(HttpServletRequest request, FeatureNotFoundException exception) {
        return this.buildResponseEntity(exception.getMessage(), request, HttpStatus.NOT_FOUND);
    }

    /**
     * Builds a Response Entity with the REST Error message.
     * 
     * @param message   message for the error.
     * @param request   http request.
     * @param status    http status.
     * @return  Response Entity with the RestError information.
     */
    private ResponseEntity<RestError> buildResponseEntity(String message, HttpServletRequest request, HttpStatus status) {
        return new ResponseEntity<>(new RestError(new Date(), status.value(), status.getReasonPhrase(), message, request.getServletPath()), status);
    }
}
