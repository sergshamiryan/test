package am.rubo.SpringMVCRubo.service.Impl;



import am.rubo.SpringMVCRubo.model.Comment;
import am.rubo.SpringMVCRubo.model.exceptions.InternalServerException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;
import am.rubo.SpringMVCRubo.repository.CommentRepository;
import am.rubo.SpringMVCRubo.service.CommentService;
import am.rubo.SpringMVCRubo.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static am.rubo.SpringMVCRubo.util.Messages.INTERNAL_SERVICE_ERROR;

@Service
public class CommentServiceImpl  implements CommentService {


   private CommentRepository commentRepository;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }


    @Override
    public List <Comment> getByUserId(int userId) throws InternalServerException {
       return commentRepository.getByUserId(userId);
    }


    @Override
    public void add(Comment comment) throws InternalServerException {
        try {
            commentRepository.save(comment);
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new InternalServerException(INTERNAL_SERVICE_ERROR);
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        try{
            commentRepository.deleteById(id);
        }catch (RuntimeException e){
            throw new NotFoundException(INTERNAL_SERVICE_ERROR);
        }
    }

    @Override
     public void update(Comment comment){
        commentRepository.save(comment);
     }
}
