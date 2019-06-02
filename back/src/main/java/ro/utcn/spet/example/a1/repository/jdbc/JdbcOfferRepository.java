package ro.utcn.spet.example.a1.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.OfferRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RequiredArgsConstructor
public class JdbcOfferRepository implements OfferRepository {
    private final JdbcTemplate template;

    @Override
    public Offer save(Offer offer){
        if(offer.getId() !=0){
            update(offer);
        } else{
            offer.setId(insert (offer));

        }

        return offer;
    }


    @Override
    public Optional<Offer> findById(int id){
        List<Offer> offers =template.query("SELECT * FROM offer WHERE id=?",
                new Object[]{id},(resultSet,i)->new Offer(resultSet.getInt("id"),resultSet.getString("title"),
                        resultSet.getString("description"),resultSet.getString("location"), resultSet.getString("author"), resultSet.getString("creation_date"),resultSet.getString("available_date") ));

        return offers.isEmpty()? Optional.empty():Optional.of(offers.get(0));
    }

    @Override
    public void remove(Offer offer){
        template.update("DELETE FROM offer WHERE id=?", offer.getId());
    }
    @Override
    public List<Offer> findAll(){
        return template.query("SELECT * FROM offer",(resultSet,i)->new Offer(resultSet.getInt("id"),resultSet.getString("title"),
                resultSet.getString("description"),resultSet.getString("location"), resultSet.getString("author"), resultSet.getString("creation_date"),resultSet.getString("available_date") ));

    }
    private int insert(Offer offer){
        SimpleJdbcInsert insert=new SimpleJdbcInsert(template);
        insert.setTableName("offer");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data=new HashMap<>();
        data.put("title", offer.getTitle());
        data.put("description", offer.getDescription());
        data.put("location", offer.getLocation());
        data.put("author", offer.getAuthor());

        data.put("creation_date", offer.getCreationDate());
        data.put("available_date", offer.getAvailableDate());

        return insert.executeAndReturnKey(data).intValue();

    }

    private void update(Offer offer) {

        template.update("UPDATE offer SET title=?,description=? WHERE id=?", offer.getTitle(), offer.getDescription(), offer.getId());

    }
}
