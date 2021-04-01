package ch.supsi.webapp.web;

import ch.supsi.webapp.web.model.*;
import ch.supsi.webapp.web.repository.AuthorRepository;
import ch.supsi.webapp.web.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ItemRepository repository, AuthorRepository authorRepository) {
        return (args) -> {
            if (repository.count() == 0) {
                final Role role = new Role("Developer");
                final Author author = new Author("admin", role);
                author.setRole(role);
                final ItemCategory itemCategory = ItemCategory.JOB;
                final ItemType type = ItemType.OFFER;
                final Date date = Date.from(Instant.now());
                final Item item = new Item(date, "ciao", "mondo", author, itemCategory, type);
//				roleRepository.save(role);
//				categoryRepository.save(category);
//				userRepository.save(user);
//				repository.save(item);
                repository.save(item);
            }
        };
    }
}
