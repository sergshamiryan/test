package am.rubo.SpringMVCRubo.Config;


import am.rubo.SpringMVCRubo.model.exceptions.DublicateDataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;


@ControllerAdvice
public class ExceptionConfig {


    @ExceptionHandler(DublicateDataException.class) //Մեր սարքած exception class ում class ի գլխին կարելի ա դնել @ResponseStatus(HttpStatus.CONFLICT,reason="...mesage...")
    public ResponseEntity handleException(DublicateDataException exception){
        return ResponseEntity.status(409).body(Collections.singletonMap("errorMessage",exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException exception){
       // log.error(exception.getMessage());
        return ResponseEntity.status(500).body(Collections.singletonMap("errorMessage","Something went wrong"));
    }


}
