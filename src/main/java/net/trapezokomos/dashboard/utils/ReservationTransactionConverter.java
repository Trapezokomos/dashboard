package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.ReservationTransaction;
import net.trapezokomos.dashboard.resources.ReservationTransactionResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReservationTransactionConverter implements BaseConverter<ReservationTransactionResource, ReservationTransaction> {

        @Override
        public ReservationTransactionResource convertToResource(ReservationTransaction rerservationTransaction) {
            ReservationTransactionResource reservationTransactionResource = new ReservationTransactionResource();
            reservationTransactionResource.setId(rerservationTransaction.getId());
            reservationTransactionResource.setDetails(rerservationTransaction.getDetails());
            reservationTransactionResource.setAmount(rerservationTransaction.getAmount());
            reservationTransactionResource.setReservationId(rerservationTransaction.getReservationId());
            reservationTransactionResource.setCreatedAt(rerservationTransaction.getCreatedAt());
            reservationTransactionResource.setUpdatedAt(rerservationTransaction.getUpdatedAt());
            return reservationTransactionResource;
        }

        @Override
        public ReservationTransaction convertToEntity(ReservationTransactionResource reservationTransactionResource) {
            ReservationTransaction rerservationTransaction = new ReservationTransaction();
            rerservationTransaction.setId(reservationTransactionResource.getId());
            rerservationTransaction.setDetails(reservationTransactionResource.getDetails());
            rerservationTransaction.setAmount(reservationTransactionResource.getAmount());
            rerservationTransaction.setReservationId(reservationTransactionResource.getReservationId());
            rerservationTransaction.setCreatedAt(reservationTransactionResource.getCreatedAt());
            rerservationTransaction.setUpdatedAt(reservationTransactionResource.getUpdatedAt());
            return rerservationTransaction;
        }

        public ReservationTransactionResource createReservationTransactionResource(String details, Double amount, Long reservationId, Date createdAt, Date updatedAt) {
            ReservationTransactionResource reservationTransactionResource = new ReservationTransactionResource();
            reservationTransactionResource.setDetails(details);
            reservationTransactionResource.setAmount(amount);
            reservationTransactionResource.setReservationId(reservationId);
            reservationTransactionResource.setCreatedAt(createdAt);
            reservationTransactionResource.setUpdatedAt(updatedAt);
            return reservationTransactionResource;
        }

}
