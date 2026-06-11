package br.com.pedroppaf.onvagas.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException(){
        super("Usuário já existe");
    }
}
