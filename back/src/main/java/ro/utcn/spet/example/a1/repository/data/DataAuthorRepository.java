package ro.utcn.spet.example.a1.repository.data;

import org.springframework.data.repository.Repository;
import ro.utcn.spet.example.a1.entity.Author;
import ro.utcn.spet.example.a1.repository.memory.AuthorRepository;

public interface DataAuthorRepository  extends Repository<Author, Integer>, AuthorRepository {
}
