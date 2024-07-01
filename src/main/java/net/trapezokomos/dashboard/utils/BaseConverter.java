package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public interface BaseConverter<T, D> extends AttributeConverter<T, D>  {
    D convertToDatabaseColumn(T entity);
    T convertToEntityAttribute(D entity);
}
