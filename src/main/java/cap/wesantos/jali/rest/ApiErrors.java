package cap.wesantos.jali.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    @Getter
    private final List<String> errors;

    public ApiErrors(String mensagemErro) {
        this.errors = Arrays.asList(mensagemErro);
    }

    public ApiErrors(List<String> mensagensErro) {
        this.errors = mensagensErro;
    }

}
