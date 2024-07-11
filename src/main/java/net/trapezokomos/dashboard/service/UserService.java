package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.UserRepository;
import net.trapezokomos.dashboard.resources.UserResource;
import net.trapezokomos.dashboard.utils.UserConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserResource> {

    private final UserConverter userConverter;
    private final UserRepository repository;

    @Override
    public Page<UserResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(userConverter::convertToEntityAttribute);
    }

    @Override
    public UserResource save(UserResource userResource) throws GenericException {
        User user = userConverter.convertToDatabaseColumn(userResource);
        if (repository.existsByEmailOrPhoneNumber(user.getEmail(), user.getPhoneNumber())) {
            throw new GenericException();
        }
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return Optional.of(repository.save(user)).map(userConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the user."));
    }

    @Override
    public UserResource update(UserResource userResource, Long id) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the user."));
        existingUser.setEmail(userResource.getEmail());
        existingUser.setFirstName(userResource.getFirstName());
        existingUser.setLastName(userResource.getLastName());
        existingUser.setPhoneNumber(userResource.getPhoneNumber());
        existingUser.setCustomerId(userResource.getCustomerId());
        existingUser.setRole(userResource.getRole());
        existingUser.setUpdatedAt(new Date());
        return Optional.of(repository.save(existingUser)).map(userConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not update the user."));
    }

    @Override
    public void delete(Long id) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the user."));
        repository.delete(existingUser);
    }

    public UserResource get(Long id) {
        return repository.findById(id)
                .map(userConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the user."));
    }

    public Page<UserResource> list(Pageable pageable, Specification<User> filter) {
        return repository.findAll(filter, pageable).map(userConverter::convertToEntityAttribute);
    }

    //    public List<UserResource> search(String filterText) {
//        return repository.search(filterText).stream().map(userConverter::convertToEntityAttribute).collect(Collectors.toList());
//    }
}
