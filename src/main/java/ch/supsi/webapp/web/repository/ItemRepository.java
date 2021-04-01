package ch.supsi.webapp.web.repository;

import ch.supsi.webapp.web.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer> {

    @Override
    List<Item> findAll();

    @Override
    Item save(final Item toAdd);

    @Override
    Optional<Item> findById(final Integer id);

    @Override
    void deleteById(final Integer id);

}
