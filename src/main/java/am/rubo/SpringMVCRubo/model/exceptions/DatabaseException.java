package am.rubo.SpringMVCRubo.model.exceptions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(Throwable throwable){
        super(throwable);
    }

}
