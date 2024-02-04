package org.projeto.mongodb.resources.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.projeto.mongodb.exception.ObjetNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandleer {

    @ExceptionHandler(ObjetNotFoundException.class)

    public ResponseEntity<StandardError> objectNotFound(ObjetNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
