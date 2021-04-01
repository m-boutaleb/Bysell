package ch.supsi.webapp.web.repository;

import ch.supsi.webapp.web.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    @Override
    Author save(final Author author);

    @Override
    List<Author> findAll();

    @Override
    void deleteById(final String id);

    @Override
    Optional<Author> findById(final String id);
}
