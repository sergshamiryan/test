package am.rubo.SpringMVCRubo.model.exceptions;

public class InternalServerException extends Exception {

    public InternalServerException (String message){
        super(message);
    }

    public InternalServerException (String message,Throwable cause){
        super(message,cause);
    }


    public static void check(boolean expresion,String message) throws InternalServerException {
        if (expresion)
            throw new InternalServerException(message);
    }

}
