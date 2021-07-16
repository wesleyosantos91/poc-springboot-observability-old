package io.github.wesleyosantos91.exception.interceptor;

import io.github.wesleyosantos91.exception.core.ObjectNotFoundException;
import io.github.wesleyosantos91.domain.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerPessoaNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setMessage(e.getMessage());
        error.setTimestamp(OffsetDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
