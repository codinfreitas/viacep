package br.com.consulta.viacep.exception;

public class ViaCepFormatException extends Exception {

    public ViaCepFormatException() {
    }

    public ViaCepFormatException(String message) {
        super(message);
    }

    public ViaCepFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViaCepFormatException(Throwable cause) {
        super(cause);
    }

    public ViaCepFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
