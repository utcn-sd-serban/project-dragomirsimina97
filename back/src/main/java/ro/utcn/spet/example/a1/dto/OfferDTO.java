package ro.utcn.spet.example.a1.dto;
import lombok.Data;
import ro.utcn.spet.example.a1.entity.Offer;

@Data
public class OfferDTO {
    private String Title;
    private String Description;
    private String Author;
    private String Location;
    private String CreationDate;
    private String AvailableDate;


    public static OfferDTO ofEntity(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setTitle(offer.getTitle());
        offerDTO.setDescription(offer.getDescription());
        offerDTO.setAuthor(offer.getAuthor());
        offerDTO.setLocation(offer.getLocation());
        offerDTO.setCreationDate(offer.getCreationDate());
        offerDTO.setAvailableDate(offer.getAvailableDate());

        return offerDTO;
    }
}
