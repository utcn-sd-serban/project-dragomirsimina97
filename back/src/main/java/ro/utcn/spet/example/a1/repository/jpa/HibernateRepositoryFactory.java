package ro.utcn.spet.example.a1.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.dto.AuthorDTO;
import ro.utcn.spet.example.a1.repository.*;
import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "JPA")
public class HibernateRepositoryFactory implements RepositoryFactory {

	private final EntityManager entityManager2;




	@Override
	public OfferRepository createOfferRepository() {
		return new HibernateOfferRepository(entityManager2);
	}
	@Override
	public AuthorRepository createAuthorRepository() {
		return new HibernateAuthorRepository(entityManager2);
	}

}