package ro.utcn.spet.example.a1.command;

import lombok.RequiredArgsConstructor;
import ro.utcn.spet.example.a1.dto.OfferDTO;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.OfferRepository;

@RequiredArgsConstructor
public class AskCommand implements Command {

    private final OfferRepository offerRepository;

    @Override
    public OfferDTO execute(OfferDTO dto) {
        Offer offer = new Offer();
        offer.setTitle(dto.getTitle());
        offer.setDescription(dto.getDescription());
        offer.setLocation(dto.getLocation());
        offer.setAuthor(dto.getAuthor());
        offer.setCreationDate(dto.getCreationDate());
        offer.setAvailableDate(dto.getAvailableDate());
        return OfferDTO.ofEntity(offerRepository.save(offer));
    }
}
