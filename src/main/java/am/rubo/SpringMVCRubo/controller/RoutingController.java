package am.rubo.SpringMVCRubo.controller;

import am.rubo.SpringMVCRubo.util.Pages;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static am.rubo.SpringMVCRubo.util.Pages.*;

@Controller
public class RoutingController {


    @GetMapping("/")
    public String getStartPage(){
        return INDEX_PAGE;
    }

    @GetMapping("/register")
    public  String getRegisterPage(){
        return REGISTER_PAGE;
    }

    @GetMapping("/delete")
    public String getDeletePage(){
        return DELETION_PAGE;
    }

    @GetMapping("/home")
    public String getHomePage(){
        return HOME_PAGE;
    }



}
