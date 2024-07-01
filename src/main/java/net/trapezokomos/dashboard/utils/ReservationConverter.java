package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.Reservation;
import net.trapezokomos.dashboard.resources.ReservationResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReservationConverter implements BaseConverter<ReservationResource, Reservation> {

    @Override
    public ReservationResource convertToResource(Reservation reservation) {
        ReservationResource reservationResource = new ReservationResource();
        reservationResource.setId(reservation.getId());
        reservationResource.setConsumerId(reservation.getConsumerId());
        reservationResource.setTableId(reservation.getTableId());
        reservationResource.setStartTime(reservation.getStartTime());
        reservationResource.setEndTime(reservation.getEndTime());
        reservationResource.setDate(reservation.getDate());
        reservationResource.setTotalPrice(reservation.getTotalPrice());
        reservationResource.setCreatedAt(reservation.getCreatedAt());
        reservationResource.setStatus(reservation.getStatus());
        reservationResource.setUpdatedAt(reservation.getUpdatedAt());
        return reservationResource;
    }

    @Override
    public Reservation convertToEntity(ReservationResource reservationResource) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationResource.getId());
        reservation.setConsumerId(reservationResource.getConsumerId());
        reservation.setTableId(reservationResource.getTableId());
        reservation.setStartTime(reservationResource.getStartTime());
        reservation.setEndTime(reservationResource.getEndTime());
        reservation.setDate(reservationResource.getDate());
        reservation.setTotalPrice(reservationResource.getTotalPrice());
        reservation.setCreatedAt(reservationResource.getCreatedAt());
        reservation.setStatus(reservationResource.getStatus());
        reservation.setUpdatedAt(reservationResource.getUpdatedAt());
        return reservation;
    }

    public ReservationResource createReservation(Long consumerId, Long tableId, Date startTime, Date endTime, Date date, Double totalPrice, Date createdAt, String status) {
        ReservationResource reservationResource = new ReservationResource();
        reservationResource.setConsumerId(consumerId);
        reservationResource.setTableId(tableId);
        reservationResource.setStartTime(startTime);
        reservationResource.setEndTime(endTime);
        reservationResource.setDate(date);
        reservationResource.setStatus(status);
        reservationResource.setTotalPrice(totalPrice);
        reservationResource.setCreatedAt(createdAt);
        return reservationResource;
    }
}
