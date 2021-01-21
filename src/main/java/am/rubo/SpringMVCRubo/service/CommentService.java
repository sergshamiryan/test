package am.rubo.SpringMVCRubo.service;

import am.rubo.SpringMVCRubo.model.Comment;
import am.rubo.SpringMVCRubo.model.exceptions.InternalServerException;
import am.rubo.SpringMVCRubo.model.exceptions.NotFoundException;

import java.util.List;

public interface CommentService {
    List<Comment> getByUserId(int userId) throws InternalServerException;

    void add(Comment comment) throws InternalServerException;

    void delete(int id) throws NotFoundException;

    void update(Comment comment);
}
