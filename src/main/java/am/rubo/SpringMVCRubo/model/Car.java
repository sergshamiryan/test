package am.rubo.SpringMVCRubo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @NotBlank
    private String model;

    @NotBlank
    private String vendor;

    @NotBlank
    @Size(min = 4)
    private String vin;

    private int year;

}
