package am.rubo.SpringMVCRubo.controller;


import am.rubo.SpringMVCRubo.model.User;
import am.rubo.SpringMVCRubo.model.exceptions.DublicateDataException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;
import am.rubo.SpringMVCRubo.service.UserService;
import am.rubo.SpringMVCRubo.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static am.rubo.SpringMVCRubo.util.Messages.INTERNAL_SERVICE_ERROR;
import static am.rubo.SpringMVCRubo.util.Pages.*;
import static am.rubo.SpringMVCRubo.util.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;
import static am.rubo.SpringMVCRubo.util.ParameterKeys.USER_ATTRIBUTE_KEY;


@Controller
public class AccountController {

     @Autowired
    private UserService userService;




     @PostMapping("/login")
    public ModelAndView login(@RequestParam String username,@RequestParam String password, HttpSession session){

         try {
             User user = userService.login(username,password);
             session.setAttribute(USER_ATTRIBUTE_KEY,user);
             return new ModelAndView(HOME_PAGE);
         } catch (NotFoundException e) {
             return new ModelAndView(INDEX_PAGE,MESSAGE_ATTRIBUTE_KEY,e.getMessage());
         }catch (RuntimeException e){
             e.printStackTrace();
             return new ModelAndView(INDEX_PAGE,MESSAGE_ATTRIBUTE_KEY, Messages.INTERNAL_SERVICE_ERROR);
         }
     }


     @GetMapping("/logout")
      public String logOut(HttpSession session){
         session.invalidate();
         return "index";
     }


     @PostMapping("/register")
    public ModelAndView register(@RequestParam String name,
                                 @RequestParam String surname,
                                 @RequestParam String username,
                                 @RequestParam String password){

         User user = new User();
         user.setName(name);
         user.setSurname(surname);
         user.setUsername(username);
         user.setPassword(password);

         try {
             userService.register(user);
             return new ModelAndView(INDEX_PAGE,MESSAGE_ATTRIBUTE_KEY,Messages.ACCOUNT_CREATION_SUCCESS);
         } catch (DublicateDataException e) {
             return new ModelAndView("register",MESSAGE_ATTRIBUTE_KEY,e.getMessage());
         }catch (RuntimeException e){
             return new ModelAndView("register",MESSAGE_ATTRIBUTE_KEY,Messages.INTERNAL_SERVICE_ERROR);
         }
     }



     @PostMapping("/delete")
    public ModelAndView deletAccount(@RequestParam String username,@RequestParam String password){

         try {
             userService.deleteUser(username,password);
             return new ModelAndView(INDEX_PAGE,MESSAGE_ATTRIBUTE_KEY,Messages.DELETION_OF_ACCOUNT);
         } catch (NotFoundException e) {
             return new ModelAndView(DELETION_PAGE,MESSAGE_ATTRIBUTE_KEY,Messages.INVALID_USERNAME_MESSAGE);
         }catch (RuntimeException e){
             return new ModelAndView(DELETION_PAGE,MESSAGE_ATTRIBUTE_KEY, INTERNAL_SERVICE_ERROR);
         }
     }

}
