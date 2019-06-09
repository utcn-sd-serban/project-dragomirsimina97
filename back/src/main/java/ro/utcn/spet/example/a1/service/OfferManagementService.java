package ro.utcn.spet.example.a1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.spet.example.a1.command.CommandFactory;
import ro.utcn.spet.example.a1.dto.OfferDTO;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.exception.OfferNotFoundException;
import ro.utcn.spet.example.a1.repository.OfferRepository;
import ro.utcn.spet.example.a1.repository.RepositoryFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferManagementService {
    private final RepositoryFactory repositoryFactory;
    private final OfferRepository offerRepository;
    private final CommandFactory commandFactory;

    @Transactional
    public List<OfferDTO> offer() {
        List<OfferDTO> myOffers = repositoryFactory.createOfferRepository().findAll().stream().map(OfferDTO::ofEntity).collect(Collectors.toList());
        Collections.reverse(myOffers);

        return myOffers;

    }
    @Transactional
    public List<OfferDTO> findtitle(String title) {
        List<Offer> myOffers = repositoryFactory.createOfferRepository().findAll().stream().filter(q->
                q.getTitle().toLowerCase().equals(title.toLowerCase())).collect(Collectors.toList());
        List<OfferDTO> offersOut = new ArrayList<>();
        for (Offer q: myOffers
             ) {
            offersOut.add(OfferDTO.ofEntity(q));
        }

        return offersOut;

    }
    @Transactional
    public List<OfferDTO> findLocation(String location) {
        List<Offer> myOffers = repositoryFactory.createOfferRepository().findAll().stream().filter(q->
                q.getLocation().toLowerCase().equals(location.toLowerCase())).collect(Collectors.toList());
        List<OfferDTO> offersOut = new ArrayList<>();
        for (Offer q: myOffers
        ) {
           offersOut.add(OfferDTO.ofEntity(q));
        }

        return offersOut;

    }
    @Transactional
    public List<OfferDTO> findAvailableDate(String available_date) {
        List<Offer> myOffers = repositoryFactory.createOfferRepository().findAll().stream().filter(q->
                q.getAvailableDate().toLowerCase().equals(available_date.toLowerCase())).collect(Collectors.toList());
        List<OfferDTO> offersOut = new ArrayList<>();
        for (Offer q: myOffers
        ) {
           offersOut.add(OfferDTO.ofEntity(q));
        }

        return offersOut;

    }
    @Transactional
    public Optional<Offer> findbyid(int id) {
       Optional <Offer> myOffers = repositoryFactory.createOfferRepository().findAll().stream().filter((Offer q)->q.getTitle().equals(id)).findFirst();


        return myOffers;

    }


    @Transactional
    public OfferDTO insert (OfferDTO dto) {
        return commandFactory.askCommand().execute(dto);
    }

    @Transactional
    public void update(int id,String title,String text,String location,String author,String creationDate,String availableDate) {
        OfferRepository repository = repositoryFactory.createOfferRepository();
        Offer offer = repository.findById(id).orElseThrow(OfferNotFoundException::new);
        offer.setDescription(text);
        offer.setTitle(title);
        offer.setAuthor(author);
        offer.setLocation(location);
        offer.setCreationDate(creationDate);
        offer.setAvailableDate(availableDate);
        repositoryFactory.createOfferRepository().save(offer);
    }

    @Transactional
    public void remove(int id) {
        OfferRepository repository = repositoryFactory.createOfferRepository();
        Offer offer = repository.findById(id).orElseThrow(OfferNotFoundException::new);
        repository.remove(offer);
    }
}
