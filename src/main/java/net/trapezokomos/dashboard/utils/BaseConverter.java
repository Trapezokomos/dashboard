package net.trapezokomos.dashboard.utils;

public interface BaseConverter<T, D> {

    T convertToResource(D d);
    D convertToEntity(T t);
}
