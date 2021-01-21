package am.rubo.SpringMVCRubo.repository;

import am.rubo.SpringMVCRubo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardReposytory extends JpaRepository <Card,Integer> {

    Optional<Card> getById(int id);

    Card getByHoler (String holder);
}
