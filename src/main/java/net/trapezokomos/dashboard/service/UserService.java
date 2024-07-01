package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.repository.UserRepository;
import net.trapezokomos.dashboard.resources.UserResource;
import net.trapezokomos.dashboard.utils.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService implements BaseService<UserResource> {

    private final UserRepository repository;
    @Autowired
    private UserConverter userConverter;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<UserResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(userConverter::convertToResource);
    }

    @Override
    public UserResource save(UserResource userResource) throws ResourceAlreadyExistsException {
        User user = userConverter.convertToEntity(userResource);
        if (repository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new ResourceAlreadyExistsException();
        }
        return Optional.of(repository.save(user)).map(userConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not create the user."));
    }

    @Override
    public UserResource update(UserResource userResource, Long id) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the user."));
        existingUser.setUsername(userResource.getUsername());
        existingUser.setEmail(userResource.getEmail());
        existingUser.setFirstName(userResource.getFirst_name());
        existingUser.setLastName(userResource.getLast_name());
        existingUser.setPhoneNumber(userResource.getPhone_number());
        existingUser.setCustomerId(userResource.getCustomerId());
        existingUser.setRoles(userResource.getRoles());
        existingUser.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingUser)).map(userConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not update the user."));
    }

    @Override
    public void delete(Long id) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find the user."));
        repository.delete(existingUser);
    }

    public UserResource get(Long id) {
        return repository.findById(id)
                .map(userConverter::convertToResource)
                .orElseThrow(() -> new RuntimeException("Could not find the user."));
    }

//    public List<UserResource> search(String filterText) {
//        return repository.search(filterText).stream().map(userConverter::convertToResource).collect(Collectors.toList());
//    }

    public Page<UserResource> list(Pageable pageable, Specification<User> filter) {
        return repository.findAll(filter, pageable).map(userConverter::convertToResource);
    }
}
