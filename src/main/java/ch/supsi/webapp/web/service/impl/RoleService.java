package ch.supsi.webapp.web.service.impl;

import ch.supsi.webapp.web.model.Role;
import ch.supsi.webapp.web.repository.RoleRepository;
import ch.supsi.webapp.web.service.IRoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> get(final String id) {
        return roleRepository.findById(id);
    }

    @Override
    public void delete(final String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role add(final Role role) {
        return (roleRepository.save( role));
    }

}
