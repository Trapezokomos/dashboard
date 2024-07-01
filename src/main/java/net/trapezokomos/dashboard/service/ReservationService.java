package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Reservation;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.repository.ReservationRepository;
import net.trapezokomos.dashboard.resources.ReservationResource;
import net.trapezokomos.dashboard.utils.ReservationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService implements BaseService<ReservationResource> {

    private final ReservationRepository repository;
    @Autowired private ReservationConverter reservationConverter;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }


    @Override
    public ReservationResource save(ReservationResource entity) throws ResourceAlreadyExistsException {
        Reservation reservation = reservationConverter.convertToEntity(entity);
        return Optional.of(repository.save(reservation)).map(reservationConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not create the reservation."));
    }

    @Override
    public void delete(Long T) {
        Reservation existingReservation = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation."));
        repository.delete(existingReservation);
    }

    @Override
    public Page<ReservationResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(reservationConverter::convertToResource);
    }

    @Override
    public ReservationResource update(ReservationResource entity, Long T) {
        Reservation existingReservation = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation."));
        existingReservation.setConsumerId(entity.getConsumerId());
        existingReservation.setTableId(entity.getTableId());
        existingReservation.setDate(entity.getDate());
        existingReservation.setStartTime(entity.getStartTime());
        existingReservation.setEndTime(entity.getEndTime());
        existingReservation.setTotalPrice(entity.getTotalPrice());
        existingReservation.setStatus(entity.getStatus());
        return reservationConverter.convertToResource(repository.save(existingReservation));
    }

    @Override
    public ReservationResource get(Long T) {
        return repository.findById(T)
                .map(reservationConverter::convertToResource)
                .orElseThrow(() -> new RuntimeException("Could not find the reservation."));
    }
}
