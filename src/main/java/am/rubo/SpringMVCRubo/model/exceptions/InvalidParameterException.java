package am.rubo.SpringMVCRubo.model.exceptions;

public class InvalidParameterException extends Exception {

    public InvalidParameterException (String message){
        super(message);
    }

    public static void check (boolean expresion,String message) throws InvalidParameterException {
        if (expresion){
            throw new InvalidParameterException(message);
        }
    }

}
