package br.com.ada.programacaowebIsb.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;

@ControllerAdvice
public class ErrorHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidation(MethodArgumentNotValidException exception){
        LinkedHashMap<String, String> erros = new LinkedHashMap<>();
        exception.getBindingResult().getAllErrors().forEach((ObjectError erro) -> {
            String nomeCampo = ((FieldError) erro).getField();
            String mensagem = erro.getDefaultMessage();
            erros.put(nomeCampo, mensagem);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

}
