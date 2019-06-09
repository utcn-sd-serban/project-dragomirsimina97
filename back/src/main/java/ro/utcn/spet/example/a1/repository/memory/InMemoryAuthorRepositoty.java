package ro.utcn.spet.example.a1.repository.memory;

import ro.utcn.spet.example.a1.entity.Author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAuthorRepositoty implements AuthorRepository{
    private final Map<Integer, Author> data=new HashMap<>();
    private int currentId=1;
    @Override

    public List<Author> findAll(){
        return new ArrayList<>(data.values());
    }
    @Override

    public synchronized Author save (Author offer){
        if(offer.getId()!=0){
            data.put(offer.getId(), offer);
        } else {

            offer.setId(currentId++);
            data.put(offer.getId(), offer);
        }

        return offer;
    }
}
