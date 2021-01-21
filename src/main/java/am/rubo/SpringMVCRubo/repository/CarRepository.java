package am.rubo.SpringMVCRubo.repository;

import am.rubo.SpringMVCRubo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {


    boolean existsByVin(String vin);


    boolean existsByVinAndIdNot(String vin, int id);
}