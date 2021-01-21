package am.rubo.SpringMVCRubo.util;

public class UsernameValidator {

    public static boolean isValid(String username){
        return username != null && username.length()<=3;
    }
}
