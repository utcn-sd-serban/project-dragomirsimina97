package ro.utcn.spet.example.a1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;

    private String last_name;
    private String phone;
    private String review;

    public Author(String first_name, String last_name, String phone, String review) {
        this.first_name = first_name;
        this.last_name =last_name;
        this.phone=phone;
        this.review=review;



    }

}
