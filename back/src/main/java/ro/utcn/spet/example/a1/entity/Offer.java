package ro.utcn.spet.example.a1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String author;
    private String location;
    private String creationDate;
    private String availableDate;


    public Offer(String title, String description, String author, String location, String creationDate, String availableDate) {
        this.title = title;
        this.description = description;
        this.author=author;
        this.location=location;
        this.creationDate=creationDate;
        this.availableDate=availableDate;


    }
}
