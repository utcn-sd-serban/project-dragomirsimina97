package ro.utcn.spet.example.a1.repository.memory;

import ro.utcn.spet.example.a1.entity.Author;

import java.util.List;

public interface AuthorRepository {
    List<Author> findAll();
    Author save(Author author);
}
