package am.rubo.SpringMVCRubo.model.exceptions;

public class AccessDeniedException extends Exception {

   public AccessDeniedException (String message){
       super(message);
   }

   public static void check(boolean expression,String message) throws AccessDeniedException {
       if (expression){
           throw new AccessDeniedException(message);
       }
   }

}
