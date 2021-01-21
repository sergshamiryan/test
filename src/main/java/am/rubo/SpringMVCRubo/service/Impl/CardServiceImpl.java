package am.rubo.SpringMVCRubo.service.Impl;

import am.rubo.SpringMVCRubo.model.Card;
import am.rubo.SpringMVCRubo.repository.CardReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl {

    @Autowired
    private CardReposytory cardReposytory;



    public  Optional <Card> getById(int id){
       return cardReposytory.getById(id);
    }






}
