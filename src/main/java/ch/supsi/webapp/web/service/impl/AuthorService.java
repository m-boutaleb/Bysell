package ch.supsi.webapp.web.service.impl;

import ch.supsi.webapp.web.model.Author;
import ch.supsi.webapp.web.repository.AuthorRepository;
import ch.supsi.webapp.web.service.IAuthorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AuthorService implements IAuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Iterable<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> get(final String id) {
        return authorRepository.findById(id);
    }

    @Override
    public void delete(final String id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author add(final Author newItem) {
        return (authorRepository.save(newItem));
    }

}
