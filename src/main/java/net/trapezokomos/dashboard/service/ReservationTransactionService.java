package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.ReservationTransaction;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.repository.ReservationTransactionRepository;
import net.trapezokomos.dashboard.resources.ReservationTransactionResource;
import net.trapezokomos.dashboard.utils.ReservationTransactionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationTransactionService implements BaseService<ReservationTransactionResource> {

    private final ReservationTransactionRepository repository;
    @Autowired private ReservationTransactionConverter reservationTransactionConverter;

    public ReservationTransactionService(ReservationTransactionRepository repository) {
        this.repository = repository;
    }


    @Override
    public ReservationTransactionResource save(ReservationTransactionResource entity) throws GenericException {
        ReservationTransaction reservationTransaction = reservationTransactionConverter.convertToDatabaseColumn(entity);
        return Optional.of(repository.save(reservationTransaction)).map(reservationTransactionConverter::convertToEntityAttribute).orElseThrow(() -> new RuntimeException("Could not create the reservation transaction."));
    }

    @Override
    public void delete(Long T) {
        ReservationTransaction existingReservationTransaction = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation transaction."));
        repository.delete(existingReservationTransaction);
    }

    @Override
    public Page<ReservationTransactionResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(reservationTransactionConverter::convertToEntityAttribute);
    }

    @Override
    public ReservationTransactionResource update(ReservationTransactionResource entity, Long T) {
        ReservationTransaction existingReservationTransaction = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation transaction."));
        existingReservationTransaction.setDetails(entity.getDetails());
        existingReservationTransaction.setCreatedAt(entity.getCreatedAt());
        existingReservationTransaction.setUpdatedAt(entity.getUpdatedAt());
        return reservationTransactionConverter.convertToEntityAttribute(repository.save(existingReservationTransaction));
    }

    @Override
    public ReservationTransactionResource get(Long id) {
        return repository.findById(id)
                .map(reservationTransactionConverter::convertToEntityAttribute)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation transaction."));
    }
}
