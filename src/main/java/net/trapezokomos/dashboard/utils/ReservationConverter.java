package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Reservation;
import net.trapezokomos.dashboard.resources.ReservationResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Converter
public class ReservationConverter implements AttributeConverter<ReservationResource, Reservation> {

    @Override
    public Reservation convertToDatabaseColumn(ReservationResource reservationResource) {
        return Reservation.builder()
                .id(reservationResource.getId())
                .consumerId(reservationResource.getConsumerId())
                .tableId(reservationResource.getTableId())
                .startTime(reservationResource.getStartTime())
                .endTime(reservationResource.getEndTime())
                .date(reservationResource.getDate())
                .totalPrice(reservationResource.getTotalPrice())
                .createdAt(reservationResource.getCreatedAt())
                .status(reservationResource.getStatus())
                .version(reservationResource.getVersion())
                .build();
    }

    @Override
    public ReservationResource convertToEntityAttribute(Reservation reservation) {
        return ReservationResource.builder()
                .id(reservation.getId())
                .consumerId(reservation.getConsumerId())
                .tableId(reservation.getTableId())
                .startTime(reservation.getStartTime())
                .endTime(reservation.getEndTime())
                .date(reservation.getDate())
                .totalPrice(reservation.getTotalPrice())
                .createdAt(reservation.getCreatedAt())
                .status(reservation.getStatus())
                .version(reservation.getVersion())
                .build();
    }

    public ReservationResource createReservation(Long consumerId, Long tableId, Date startTime, Date endTime, Date date, Double totalPrice, String status) {
        return ReservationResource.builder()
                .consumerId(consumerId)
                .tableId(tableId)
                .startTime(startTime)
                .endTime(endTime)
                .date(date)
                .totalPrice(totalPrice)
                .status(status)
                .build();
    }
}
