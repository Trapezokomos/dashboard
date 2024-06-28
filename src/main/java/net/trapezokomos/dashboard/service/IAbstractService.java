package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import org.springframework.data.domain.Pageable;

public interface IAbstractService<T, ID> {
    ID save(ID entity) throws ResourceAlreadyExistsException;
    void delete(Long id);
    Iterable<ID> list(Pageable pageable);
    ID update(ID entity, Long id);
}
