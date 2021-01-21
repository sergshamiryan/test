package am.rubo.SpringMVCRubo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class DublicateDataException extends Exception {

    public DublicateDataException (String message){
        super(message);
    }

    public static void check(boolean expresion,String message) throws DublicateDataException {
        if (expresion)
            throw new DublicateDataException(message);
    }
}
