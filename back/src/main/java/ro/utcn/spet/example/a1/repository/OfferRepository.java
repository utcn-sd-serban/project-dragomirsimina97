package ro.utcn.spet.example.a1.repository;
import ro.utcn.spet.example.a1.entity.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferRepository {
   Offer save(Offer offer);

    Optional<Offer> findById(int id);
    void remove(Offer offer);

    List<Offer> findAll();

}
