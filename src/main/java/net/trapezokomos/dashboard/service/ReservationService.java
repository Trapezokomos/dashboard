package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.Reservation;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.ReservationRepository;
import net.trapezokomos.dashboard.resources.ReservationResource;
import net.trapezokomos.dashboard.utils.ReservationConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService implements BaseService<ReservationResource> {

    private final ReservationRepository repository;
    private final ReservationConverter reservationConverter;

    @Override
    public ReservationResource save(ReservationResource entity) throws GenericException {
        Reservation reservation = reservationConverter.convertToDatabaseColumn(entity);
        reservation.setCreatedAt(new Date());
        reservation.setUpdatedAt(new Date());
        return Optional.of(repository.save(reservation)).map(reservationConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the reservation."));
    }

    @Override
    public void delete(Long T) {
        Reservation existingReservation = repository.findById(T)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the reservation."));
        repository.delete(existingReservation);
    }

    @Override
    public Page<ReservationResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(reservationConverter::convertToEntityAttribute);
    }

    @Override
    public ReservationResource update(ReservationResource entity, Long T) {
        Reservation existingReservation = repository.findById(T)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the reservation."));
        existingReservation.setConsumerId(entity.getConsumerId());
        existingReservation.setTableId(entity.getTableId());
        existingReservation.setDate(entity.getDate());
        existingReservation.setStartTime(entity.getStartTime());
        existingReservation.setEndTime(entity.getEndTime());
        existingReservation.setTotalPrice(entity.getTotalPrice());
        existingReservation.setStatus(entity.getStatus());
        existingReservation.setUpdatedAt(new Date());
        return reservationConverter.convertToEntityAttribute(repository.save(existingReservation));
    }

    @Override
    public ReservationResource get(Long T) {
        return repository.findById(T)
                .map(reservationConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the reservation."));
    }
}
