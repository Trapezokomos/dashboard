package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.exception.GenericException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<T> {
    T save(T entity) throws GenericException;
    void delete(Long T);
    Page<T> list(Pageable pageable);
    T update(T entity, Long T);
    T get(Long T);
}
