package io.github.mafrawise.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class AppErros {

    @Getter
    private List<String> errors;

    public AppErros(List<String> pErros){
        this.errors = pErros;
    }

    public AppErros(String pMessage){
        this.errors = Arrays.asList(pMessage);
    }
}
