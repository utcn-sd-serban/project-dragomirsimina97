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
			offerRepository.save(new Offer("Ana", "you can fix it by yourself","nicee","11/11/11","Ibiza","11/11/11"));
			offerRepository.save(new Offer("miruna", "experience mountain moments","mountain air","Remetea","11/11/11","10/11/11"));
			offerRepository.save(new Offer( "maria", "all day scuba","Life on beach","Bali","12/12/12","01/01/13"));
			offerRepository.save(new Offer( "irina", "live in the heart of the city","City life","New York","13/12/13","01/01/14"));
		}

	}
}
