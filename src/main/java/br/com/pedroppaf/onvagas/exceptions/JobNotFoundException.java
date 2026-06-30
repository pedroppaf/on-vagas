package br.com.pedroppaf.onvagas.exceptions;

public class JobNotFoundException extends RuntimeException{

    public JobNotFoundException(){
        super("Job not found");
    }
}
