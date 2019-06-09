package ro.utcn.spet.example.a1.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ro.utcn.spet.example.a1.entity.Author;
import ro.utcn.spet.example.a1.entity.Offer;
import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class JdbcAuthorRepository  implements AuthorRepository {
    private final JdbcTemplate template;
    @Override
    public Author save(Author offer){
        if(offer.getId() !=0){
            update(offer);
        } else{
            offer.setId(insert (offer));

        }

        return offer;
    }

    private void update(Author offer) {

        template.update("UPDATE author SET first_name=?,last_name=? WHERE id=?", offer.getFirst_name(), offer.getLast_name(), offer.getId());

    }
    private int insert(Author offer){
        SimpleJdbcInsert insert=new SimpleJdbcInsert(template);
        insert.setTableName("author");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data=new HashMap<>();
        data.put("first_name", offer.getFirst_name());
        data.put("last_name", offer.getLast_name());
        data.put("phone", offer.getPhone());
        data.put("review", offer.getReview());


        return insert.executeAndReturnKey(data).intValue();

    }

    @Override
    public List<Author> findAll(){
        return template.query("SELECT * FROM author",(resultSet,i)->new Author(resultSet.getInt("id"),resultSet.getString("first_name"),
                resultSet.getString("last_name"),resultSet.getString("phone"), resultSet.getString("review") ));

    }
}
