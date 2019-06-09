package ro.utcn.spet.example.a1.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.spet.example.a1.entity.*;
import ro.utcn.spet.example.a1.repository.*;
import ro.utcn.spet.example.a1.repository.memory.AdminRepository;
import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class UserssSeed implements CommandLineRunner {
	private final RepositoryFactory factory;
	private final AdminRepository adminfactory;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Admin serban = new Admin(0, "raluca", passwordEncoder.encode("password"));
		adminfactory.save(serban);


		OfferRepository offerRepository = factory.createOfferRepository();
		if (offerRepository.findAll().isEmpty()) {
			offerRepository.save(new Offer("nicee", "you can fix it by yourself","Ana","Ibiza","11/11/11","11/11/11"));
			offerRepository.save(new Offer("mountain air", "experience mountain moments","miruna","Remetea","11/11/11","10/11/11"));
			offerRepository.save(new Offer("Life on beach" , "all day scuba","maria","Bali","12/12/12","01/01/13"));
			offerRepository.save(new Offer( "City life", "live in the heart of the city","irina","New York","13/12/13","01/01/14"));
		}
		AuthorRepository auhtorRepository= factory.createAuthorRepository();
		if ( auhtorRepository.findAll().isEmpty()) {
			auhtorRepository.save(new Author("ana", "maria","09876543","10/10"));
			auhtorRepository.save(new Author("costea", "ioana","24445345","9/10"));

		}

	}
}
