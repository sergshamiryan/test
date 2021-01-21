package am.rubo.SpringMVCRubo.controller;

import am.rubo.SpringMVCRubo.model.Card;
import am.rubo.SpringMVCRubo.repository.CardReposytory;
import am.rubo.SpringMVCRubo.service.Impl.CardServiceImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardReposytory cardRepository;

    @Autowired
    private CardServiceImpl cardService;





    @GetMapping
    public ResponseEntity getAll(){
        //return ResponeEntity.status(200).body(cardRepository.findAll())
        return ResponseEntity.ok(cardRepository.findAll());
    }




    @PostMapping
    public ResponseEntity add(@RequestBody Card card){
        return ResponseEntity.ok(cardRepository.save(card));
    }

//   էս գրելաձը հեշտացնելու համար , նայել տակինը
//    @GetMapping("/{id}")
//    public ResponseEntity getById(@PathVariable int id){
//
//        Optional<Card> optionalCard = cardService.getById(id);
//         if (!optionalCard.isPresent()){
//            return ResponseEntity.status(404).build();
//        }
//        return ResponseEntity.ok(optionalCard.get());
//    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id,
                                  @RequestHeader("Accept-Encoding") String acceptEncoding){


        Optional <Card> OptionalCard = cardRepository.getById(id);
        System.out.println(acceptEncoding);

        return ResponseEntity.of(OptionalCard);
    }


    @GetMapping("/by-name/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        return ResponseEntity.ok(cardRepository.getByHoler(name));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity  deleteById(@PathVariable int id){
        cardRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Card card ,@PathVariable int id){
        card.setId(id);
        return ResponseEntity.ok(cardRepository.save(card));

    }





}
