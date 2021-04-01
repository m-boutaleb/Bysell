package ch.supsi.webapp.web.repository;

import ch.supsi.webapp.web.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {
    @Override
    Role save(final Role role);

    @Override
    List<Role> findAll();

    @Override
    Optional<Role> findById(final String id);
}
