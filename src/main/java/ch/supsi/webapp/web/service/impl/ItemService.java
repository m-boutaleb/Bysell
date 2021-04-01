package ch.supsi.webapp.web.service.impl;

import ch.supsi.webapp.web.model.Item;
import ch.supsi.webapp.web.repository.ItemRepository;
import ch.supsi.webapp.web.service.IItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ItemService implements IItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> get(final Integer id) {
        return itemRepository.findById(id);
    }

    @Override
    public void delete(final Integer id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item add(final Item newItem) {
        return (itemRepository.save(newItem));
    }

}
