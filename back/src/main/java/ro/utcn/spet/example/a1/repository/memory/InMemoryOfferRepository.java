package ro.utcn.spet.example.a1.repository.memory;

import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.OfferRepository;

import java.util.*;

public class InMemoryOfferRepository implements OfferRepository {
    private int currentId=1;
    private final Map<Integer, Offer> data=new HashMap<>();
    @Override
    public synchronized Offer save (Offer offer){
        if(offer.getId()!=0){
            data.put(offer.getId(), offer);
        } else {

            offer.setId(currentId++);
            data.put(offer.getId(), offer);
        }

        return offer;
    }

    @Override
    public Optional<Offer> findById(int id){

        return Optional.ofNullable(data.get(id));
    }

    @Override
    public synchronized void remove (Offer offer){
        data.remove(offer.getId());
    }

    @Override

    public List<Offer> findAll(){
        return new ArrayList<>(data.values());
    }
}
