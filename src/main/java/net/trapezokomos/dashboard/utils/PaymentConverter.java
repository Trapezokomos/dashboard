package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.Payment;
import net.trapezokomos.dashboard.resources.PaymentResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentConverter implements BaseConverter<PaymentResource, Payment> {

    @Override
    public PaymentResource convertToResource(Payment payment) {
        PaymentResource paymentResource = new PaymentResource();
        paymentResource.setId(payment.getId());
        paymentResource.setAmount(payment.getAmount());
        paymentResource.setDate(payment.getDate());
        paymentResource.setStatus(payment.getStatus());
        paymentResource.setReservationConsumerId(payment.getReservationConsumerId());
        paymentResource.setCreatedAt(payment.getCreatedAt());
        paymentResource.setUpdatedAt(payment.getUpdatedAt());
        return paymentResource;
    }

    @Override
    public Payment convertToEntity(PaymentResource paymentResource) {
        Payment payment = new Payment();
        payment.setId(paymentResource.getId());
        payment.setAmount(paymentResource.getAmount());
        payment.setDate(paymentResource.getDate());
        payment.setStatus(paymentResource.getStatus());
        payment.setReservationConsumerId(paymentResource.getReservationConsumerId());
        payment.setCreatedAt(paymentResource.getCreatedAt());
        payment.setUpdatedAt(paymentResource.getUpdatedAt());
        return payment;
    }

    public PaymentResource createPaymentResource(Double amount, Date date, String status, Long reservationConsumerId, Date createdAt, Date updatedAt) {
        PaymentResource paymentResource = new PaymentResource();
        paymentResource.setAmount(amount);
        paymentResource.setDate(date);
        paymentResource.setStatus(status);
        paymentResource.setReservationConsumerId(reservationConsumerId);
        paymentResource.setCreatedAt(createdAt);
        paymentResource.setUpdatedAt(updatedAt);
        return paymentResource;
    }
}
