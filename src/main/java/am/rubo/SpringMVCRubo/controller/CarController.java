package am.rubo.SpringMVCRubo.controller;


import am.rubo.SpringMVCRubo.model.Car;
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
    public ResponseEntity add(@Valid @RequestBody Car car){
        return ResponseEntity.ok(carService.save(car));
    }

}
