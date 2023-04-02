package br.com.consulta.viacep.exception;

public class ViaCepException extends Exception {

    public ViaCepException() {
    }

    public ViaCepException(String message) {
        super(message);
    }

    public ViaCepException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViaCepException(Throwable cause) {
        super(cause);
    }

    public ViaCepException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
