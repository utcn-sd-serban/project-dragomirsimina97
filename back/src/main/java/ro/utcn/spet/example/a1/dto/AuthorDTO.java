package ro.utcn.spet.example.a1.dto;

import lombok.Data;
import ro.utcn.spet.example.a1.entity.Author;
@Data

public class AuthorDTO {
    private int id;
    private String first_name;
    private String phone;
    private String last_name;
    private String review;
    public static AuthorDTO ofEntity(Author author) {
        AuthorDTO  offerDTO = new AuthorDTO ();
        offerDTO.setFirst_name(author.getFirst_name());
        offerDTO.setLast_name(author.getLast_name());
        offerDTO.setPhone(author.getPhone());
        offerDTO.setReview(author.getReview());

        return offerDTO;
    }

}
