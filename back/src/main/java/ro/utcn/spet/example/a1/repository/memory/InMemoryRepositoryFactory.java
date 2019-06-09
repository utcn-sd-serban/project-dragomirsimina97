package ro.utcn.spet.example.a1.repository.memory;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.spet.example.a1.repository.*;

@Component
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "MEMORY")
public class InMemoryRepositoryFactory implements RepositoryFactory {

	private final InMemoryOfferRepository repository1= new InMemoryOfferRepository();
	private final InMemoryAuthorRepositoty repository2= new InMemoryAuthorRepositoty();


	@Override
	public OfferRepository createOfferRepository(){return repository1;}
	@Override
	public AuthorRepository createAuthorRepository(){return repository2;}



}
