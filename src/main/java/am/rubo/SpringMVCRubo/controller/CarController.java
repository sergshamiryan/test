package am.rubo.SpringMVCRubo.controller;


import am.rubo.SpringMVCRubo.model.Car;
import am.rubo.SpringMVCRubo.model.exceptions.DublicateDataException;
import am.rubo.SpringMVCRubo.service.Impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarServiceImpl carService;



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getByID(@PathVariable int id){
        return ResponseEntity.of(carService.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity add(@Valid @RequestBody Car car) throws DublicateDataException {

       // try {
            return ResponseEntity.ok(carService.save(car)); //Կբռնի Exception Handlerը
      //  } catch (DublicateDataException e) {
//            Map<String,String> response = new HashMap<>();
//            response.put("Error message",e.getMessage());
//            return ResponseEntity.status(409).body(response);
           // return ResponseEntity.status(409).body(Collections.singletonMap("errorMessage",e.getMessage()));
        }

        @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id,@Valid @RequestBody Car car) throws DublicateDataException {
            car.setId(id);
            return ResponseEntity.ok(carService.update(car));

        }

    }


