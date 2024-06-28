package net.trapezokomos.dashboard.utils;

public interface AbstractConverter<T, D> {

    T convertToResource(D d);
    D convertToEntity(T t);
}
