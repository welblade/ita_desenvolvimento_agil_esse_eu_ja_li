package cap.wesantos.jali.rest;

import cap.wesantos.jali.core.exception.LivroNaoEncontradoException;
import cap.wesantos.jali.core.exception.SenhaInvalidaException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApiControllerAdvisor {
    // TODO: tratar ExpiredJwtException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<String> errorMessages = exception.getBindingResult().getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ApiErrors(errorMessages);
    }

    @ExceptionHandler(SenhaInvalidaException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ApiErrors SenhaInvalidaExceptionHandler(SenhaInvalidaException exception) {
        return new ApiErrors(exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ApiErrors UsernameNotFoundExceptionHandler(UsernameNotFoundException exception) {
        return new ApiErrors(exception.getMessage());
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors LivroNaoEncontradoExceptionHandler(LivroNaoEncontradoException exception) {
        return new ApiErrors(exception.getMessage());
    }
}
