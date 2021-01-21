package am.rubo.SpringMVCRubo.controller;


import am.rubo.SpringMVCRubo.model.User;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;
import am.rubo.SpringMVCRubo.service.UserService;
import am.rubo.SpringMVCRubo.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static am.rubo.SpringMVCRubo.util.Messages.INTERNAL_SERVICE_ERROR;
import static am.rubo.SpringMVCRubo.util.Messages.PASSWORD_CHANGE_SUCCESS;
import static am.rubo.SpringMVCRubo.util.Pages.*;
import static am.rubo.SpringMVCRubo.util.Pages.DELETION_PAGE;
import static am.rubo.SpringMVCRubo.util.ParameterKeys.MESSAGE_ATTRIBUTE_KEY;

@Controller
@RequestMapping("/secure")
public class AccountsSecureController {

    @Autowired
    UserService userService;

    @PostMapping("/password")
    public ModelAndView changePassword(@RequestParam String username,
                                       @RequestParam(name = "old password") String oldPassword,
                                       @RequestParam(name = "new password") String newPassword,
                                       @SessionAttribute("user") User sessionUser){

        try {
            User user = userService.changePassword(sessionUser.getUsername(),oldPassword,newPassword);
            return new ModelAndView(HOME_PAGE,MESSAGE_ATTRIBUTE_KEY, PASSWORD_CHANGE_SUCCESS);
        } catch (NotFoundException e) {
            return new ModelAndView(HOME_PAGE,MESSAGE_ATTRIBUTE_KEY, e);
        }catch (RuntimeException e){
            return new ModelAndView(HOME_PAGE,MESSAGE_ATTRIBUTE_KEY, INTERNAL_SERVICE_ERROR);
        }
    }



}
