package am.rubo.SpringMVCRubo.model;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data//esi sax geter setter kani es
@Entity
@NoArgsConstructor
@Table(name =  "comment")
public class Comment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;

        @Column
        @NotBlank
        private String name;

        @Column
        private String description;

        @Column
        private int userId;


}
