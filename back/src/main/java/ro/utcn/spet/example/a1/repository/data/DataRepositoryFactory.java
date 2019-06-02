package ro.utcn.spet.example.a1.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import ro.utcn.spet.example.a1.repository.*;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "a1.repository-type", havingValue = "DATA")
public class DataRepositoryFactory implements RepositoryFactory {

	private final DataOfferRepository offerRepository;


	@Override
	public OfferRepository createOfferRepository() {
		return offerRepository;
	}


}