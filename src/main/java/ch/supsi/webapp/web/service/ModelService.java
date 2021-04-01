package ch.supsi.webapp.web.service;


import java.util.Optional;

public interface ModelService<T, K> {
    Iterable<T> getAll();

    Optional<T> get(final K id);

    void delete(final K id);

    T add(final T newItem);
}
