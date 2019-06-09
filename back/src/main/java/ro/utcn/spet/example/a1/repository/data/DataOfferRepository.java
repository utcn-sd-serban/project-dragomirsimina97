package ro.utcn.spet.example.a1.repository.data;

import org.springframework.data.repository.Repository;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.OfferRepository;

public interface DataOfferRepository extends Repository<Offer, Integer>, OfferRepository {
    void delete(Offer offer);

    @Override
    default void remove(Offer offer) {
        delete(offer);
    }
}
