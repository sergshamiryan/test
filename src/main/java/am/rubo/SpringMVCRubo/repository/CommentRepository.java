package am.rubo.SpringMVCRubo.repository;

import am.rubo.SpringMVCRubo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Integer> {


    List<Comment> getByUserId(int user_Id);

    Comment getById(int id);


}
