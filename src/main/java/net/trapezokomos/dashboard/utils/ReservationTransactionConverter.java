package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.ReservationTransaction;
import net.trapezokomos.dashboard.resources.ReservationTransactionResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReservationTransactionConverter implements AttributeConverter<ReservationTransactionResource, ReservationTransaction> {

    @Override
    public ReservationTransaction convertToDatabaseColumn(ReservationTransactionResource reservationTransactionResource) {
        return ReservationTransaction.builder()
                .id(reservationTransactionResource.getId())
                .details(reservationTransactionResource.getDetails())
                .amount(reservationTransactionResource.getAmount())
                .reservationId(reservationTransactionResource.getReservationId())
                .createdAt(reservationTransactionResource.getCreatedAt())
                .updatedAt(reservationTransactionResource.getUpdatedAt())
                .build();
    }

    @Override
    public ReservationTransactionResource convertToEntityAttribute(ReservationTransaction reservationTransaction) {
        return ReservationTransactionResource.builder()
                .id(reservationTransaction.getId())
                .details(reservationTransaction.getDetails())
                .amount(reservationTransaction.getAmount())
                .reservationId(reservationTransaction.getReservationId())
                .createdAt(reservationTransaction.getCreatedAt())
                .updatedAt(reservationTransaction.getUpdatedAt())
                .build();
    }

    public ReservationTransactionResource createReservationTransactionResource(String details, Double amount, Long reservationId, Date createdAt, Date updatedAt) {
        return ReservationTransactionResource.builder()
                .details(details)
                .amount(amount)
                .reservationId(reservationId)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
