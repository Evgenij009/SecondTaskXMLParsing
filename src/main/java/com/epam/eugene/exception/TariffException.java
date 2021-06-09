package com.epam.eugene.exception;

public class TariffException extends Exception{
    public TariffException() {
        super();
    }

    public TariffException(String message) {
        super(message);
    }

    public TariffException(String message, Throwable cause) {
        super(message, cause);
    }

    public TariffException(Throwable cause) {
        super(cause);
    }
}
