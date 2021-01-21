package am.rubo.SpringMVCRubo.model.exceptions;

public class DublicateDataException extends Exception {

    public DublicateDataException (String message){
        super(message);
    }

    public static void check(boolean expresion,String message) throws DublicateDataException {
        if (expresion)
            throw new DublicateDataException(message);
    }
}
