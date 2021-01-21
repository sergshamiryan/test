package am.rubo.SpringMVCRubo.controller;

import am.rubo.SpringMVCRubo.model.Comment;
import am.rubo.SpringMVCRubo.model.User;
import am.rubo.SpringMVCRubo.model.exceptions.InternalServerException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;
import am.rubo.SpringMVCRubo.service.CommentService;
import am.rubo.SpringMVCRubo.util.Messages;
import am.rubo.SpringMVCRubo.util.Pages;
import am.rubo.SpringMVCRubo.util.ParameterKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

import static am.rubo.SpringMVCRubo.util.Messages.*;
import static am.rubo.SpringMVCRubo.util.Pages.*;
import static am.rubo.SpringMVCRubo.util.ParameterKeys.*;

@Controller
@RequestMapping("/secure")
public class CommentsController {

    @Autowired
    public CommentService commentService;



    @GetMapping("/comments")
    public ModelAndView getCommentPage(@SessionAttribute("user") User sessionUser) { //=== (User user = (User) session.getAttribute("user");

        try {
            List<Comment> comments = commentService.getByUserId(sessionUser.getId());
            return new ModelAndView(COMMENT_PAGE, "commentList", comments);
        } catch (InternalServerException e) {
            return new ModelAndView(COMMENT_PAGE, MESSAGE_ATTRIBUTE_KEY, e.getMessage());
        }

    }


    @PostMapping("/comments/add")
    public ModelAndView addComment(@SessionAttribute("user") User userSession, //=== (User user = (User) session.getAttribute("user");
                                   @RequestParam String name,
                                   @RequestParam String description) {
        Comment comment = new Comment();
        comment.setName(name);
        comment.setDescription(description);
        comment.setUserId(userSession.getId());

        try {
            commentService.add(comment);
            return getCommentPage(userSession);
        } catch (InternalServerException e) {
            e.printStackTrace();
            return getCommentPage(userSession);
        }

    }

    @PostMapping("/comments/edit")
    public ModelAndView edit(@RequestParam int id,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam String submit,
                             @SessionAttribute("user") User userSession) {
        try {

            if (submit.equalsIgnoreCase("delete")) {
                commentService.delete(id);
            } else {
                Comment comment = new Comment();
                comment.setId(id);
                comment.setName(name);
                comment.setDescription(description);
                comment.setUserId(userSession.getId());
                commentService.add(comment);

            }
            return getCommentPage(userSession);

            }catch (Exception e){
                e.printStackTrace();
                return new ModelAndView(COMMENT_PAGE,MESSAGE_ATTRIBUTE_KEY, INVALID_USERNAME_MESSAGE);
        }
    }
}