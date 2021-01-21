package am.rubo.SpringMVCRubo.controller;

import am.rubo.SpringMVCRubo.model.Comment;
import am.rubo.SpringMVCRubo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class TestControllerV2 {

    @Autowired
   private CommentRepository commentRepository;


    @GetMapping(value = "/comments")
    public ResponseEntity getAllComments(){
        List <Comment> comments = commentRepository.findAll();
        return ResponseEntity.status(OK).body(comments);
    }
}
