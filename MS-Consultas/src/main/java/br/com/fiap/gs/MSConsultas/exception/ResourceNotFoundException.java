package br.com.fiap.gs.MSConsultas.exception;

public class ResourceNotFoundException extends RuntimeException {
    //RuntimeException não precisa de try/catch
    //Exceção customizada quando não encontrar um recurso
    public ResourceNotFoundException(String message) {
        super(message);
    }
}


