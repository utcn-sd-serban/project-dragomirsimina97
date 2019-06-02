package ro.utcn.spet.example.a1.repository.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.spet.example.a1.entity.Offer;

import ro.utcn.spet.example.a1.repository.OfferRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class HibernateOfferRepository implements OfferRepository {
    private final EntityManager entityManager;
    @Override
    public Offer save(Offer offer) {
        if (offer.getId() == 0) {
            entityManager.persist(offer);
            return offer;
        } else {
            return entityManager.merge(offer);
        }
    }

    @Override
    public Optional<Offer> findById(int id) {
        return Optional.ofNullable(entityManager.find(Offer.class, id));
    }
    @Override
    public void remove(Offer offer) {
        entityManager.remove(offer);
    }

    @Override

    public List<Offer> findAll() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Offer> query = builder.createQuery(Offer.class);
        query.select(query.from(Offer.class));
        return entityManager.createQuery(query).getResultList();
    }

}
