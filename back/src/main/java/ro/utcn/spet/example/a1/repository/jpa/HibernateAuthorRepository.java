package ro.utcn.spet.example.a1.repository.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.spet.example.a1.entity.Author;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@RequiredArgsConstructor
public class HibernateAuthorRepository implements AuthorRepository {
    private final EntityManager entityManager;
    @Override
    public Author save(Author offer) {
        if (offer.getId() == 0) {
            entityManager.persist(offer);
            return offer;
        } else {
            return entityManager.merge(offer);
        }
    }
    public List<Author> findAll() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> query = builder.createQuery(Author.class);
        query.select(query.from(Author.class));
        return entityManager.createQuery(query).getResultList();
    }
}
