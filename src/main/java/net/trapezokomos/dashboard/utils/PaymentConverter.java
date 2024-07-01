package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Payment;
import net.trapezokomos.dashboard.resources.PaymentResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentConverter implements AttributeConverter<PaymentResource, Payment> {

    @Override
    public Payment convertToDatabaseColumn(PaymentResource paymentResource) {
        return Payment.builder()
                .id(paymentResource.getId())
                .amount(paymentResource.getAmount())
                .date(paymentResource.getDate())
                .status(paymentResource.getStatus())
                .reservationConsumerId(paymentResource.getReservationConsumerId())
                .createdAt(paymentResource.getCreatedAt())
                .updatedAt(paymentResource.getUpdatedAt())
                .build();
    }

    @Override
    public PaymentResource convertToEntityAttribute(Payment payment) {
        return PaymentResource.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .status(payment.getStatus())
                .reservationConsumerId(payment.getReservationConsumerId())
                .createdAt(payment.getCreatedAt())
                .updatedAt(payment.getUpdatedAt())
                .build();
    }

    public PaymentResource createPaymentResource(Double amount, Date date, String status, Long reservationConsumerId, Date createdAt, Date updatedAt) {
        return PaymentResource.builder()
                .amount(amount)
                .date(date)
                .status(status)
                .reservationConsumerId(reservationConsumerId)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
