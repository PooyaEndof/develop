package ir.snappay.common;

import ir.snappay.common.base.ErrorResponse;
import ir.snappay.common.enums.ErrorEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@ControllerAdvice
@RequiredArgsConstructor
public class GeneralError {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, Locale locale) {
        return new ResponseEntity<>(ex.getBindingResult().getAllErrors().stream().map((x)->
                ErrorResponse.builder().errorCode(Objects.requireNonNull(ErrorEnum.resolve(x.getDefaultMessage())).getCode())
                        .errorMessage(messageSource.getMessage(Objects.requireNonNull(x.getDefaultMessage()),null,locale))
                        .build()).toList(), HttpStatus.OK);
    }
}
