package am.rubo.SpringMVCRubo.repository;

import am.rubo.SpringMVCRubo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository <User,Integer>{


    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    @Query(nativeQuery = true,value = "SELECT * FROM user where username = :aaa")
    User getUserN(@Param("aaa") String username);


    @Modifying  // Անպայմանա որ մեր ստեղծած փոփոխություն անող մեթոդի վրա , որ Connection ը read only չբացի
    void removeByCode(String code);
}
