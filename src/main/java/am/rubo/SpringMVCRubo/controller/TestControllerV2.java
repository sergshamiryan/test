package am.rubo.SpringMVCRubo.controller;

import am.rubo.SpringMVCRubo.model.Comment;
import am.rubo.SpringMVCRubo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.resolve;

@RestController
public class TestControllerV2 {

    @Autowired
   private CommentRepository commentRepository;


    @GetMapping(value = "/comments")
    public ResponseEntity getAllComments(){
        List <Comment> comments = commentRepository.findAll();
        return ResponseEntity.status(OK).body(comments);
    }

    @GetMapping(value = "/comments/byId")
    public ResponseEntity getById(@RequestParam int id){
        Comment comment = commentRepository.getById(id);
        if (comment == null) {
            return ResponseEntity.status(400).build();
        }
        //return new ResponseEntity(comment, HttpStatus.OK);
        return ResponseEntity.status(OK).body(comment);
    }

    @PostMapping("/comments")
    public ResponseEntity add(@RequestBody Comment comment){
       commentRepository.save(comment);
       return ResponseEntity.status(OK).body(comment);
    }


}
