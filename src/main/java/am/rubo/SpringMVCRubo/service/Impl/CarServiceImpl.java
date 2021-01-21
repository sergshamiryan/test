package am.rubo.SpringMVCRubo.service.Impl;

import am.rubo.SpringMVCRubo.model.Car;
import am.rubo.SpringMVCRubo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl  {

    @Autowired
    private CarRepository carRepository;


    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional <Car> findById(int id) {
        return carRepository.findById(id);
    }


    public Car save(Car car) {
       return carRepository.save(car);
    }
}
