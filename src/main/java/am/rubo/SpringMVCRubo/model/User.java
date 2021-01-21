package am.rubo.SpringMVCRubo.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Size(max = 25)
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @NotBlank
    @Size(min = 6, max = 25)
    @Column(name = "password", nullable = false, unique = true)
    private String password;


    private String code;


    private int status;

    @Column(name = "balance", nullable = false)
    private int balance;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    public List<Comment> comments;




    public User() {

    }


    public User(int ID, String name, String surname, String username, String password, String code, int status) {
        this.id = ID;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.code = code;
        this.status = status;
    }



}