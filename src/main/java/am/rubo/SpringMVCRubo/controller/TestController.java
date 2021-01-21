package am.rubo.SpringMVCRubo.controller;


import am.rubo.SpringMVCRubo.util.Messages;
import am.rubo.SpringMVCRubo.util.ParameterKeys;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static am.rubo.SpringMVCRubo.util.Messages.ACCOUNT_MISSING;
import static am.rubo.SpringMVCRubo.util.Messages.INVALID_USERNAME_MESSAGE;
import static am.rubo.SpringMVCRubo.util.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;

@Controller
public class TestController {


    @RequestMapping(method = RequestMethod.GET,path = "/test")
        public String test(){
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/test1")
        public ModelAndView test1(){
        return  new ModelAndView("index");
    }


}
