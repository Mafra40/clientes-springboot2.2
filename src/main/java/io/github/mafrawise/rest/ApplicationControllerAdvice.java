package io.github.mafrawise.rest;

import io.github.mafrawise.rest.exception.AppErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

//controlador de menssagens de erros
@RestControllerAdvice // Essa simples declaração já trata os erros de toda aplicação
public class ApplicationControllerAdvice {

    //Tratar erros validados
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AppErros handleValidationErros(MethodArgumentNotValidException ex){ // é o objeto que tem o retorno das validações
        BindingResult bindingResult = ex.getBindingResult();
        List<String> erros = bindingResult.getAllErrors()
                .stream()
                .map( objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());

        return  new AppErros(erros);
    }

    @ExceptionHandler //Trata erros de página não encontrada
    public ResponseEntity  handleResponseStatusException(ResponseStatusException ex){
        String menssagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        AppErros appErros = new AppErros(menssagemErro);
    return new ResponseEntity(appErros , codigoStatus);
    }
}
