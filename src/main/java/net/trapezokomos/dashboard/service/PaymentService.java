package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Payment;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.repository.PaymentRepository;
import net.trapezokomos.dashboard.resources.PaymentResource;
import net.trapezokomos.dashboard.utils.PaymentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService implements BaseService<PaymentResource> {

    private final PaymentRepository repository;
    @Autowired private PaymentConverter paymentConverter;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentResource save(PaymentResource entity) throws ResourceAlreadyExistsException {
        Payment payment = paymentConverter.convertToEntity(entity);
        return Optional.of(repository.save(payment)).map(paymentConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not create the payment."));
    }

    @Override
    public void delete(Long T) {
        Payment existingPayment = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the payment."));
        repository.delete(existingPayment);
    }

    @Override
    public Page<PaymentResource> list(Pageable pageable) {
       return repository.findAll(pageable).map(paymentConverter::convertToResource);
    }

    @Override
    public PaymentResource update(PaymentResource entity, Long T) {
        Payment existingPayment = repository.findById(T)
                .orElseThrow(() -> new RuntimeException("Could not find the payment."));
        existingPayment.setAmount(entity.getAmount());
        existingPayment.setDate(entity.getDate());
        existingPayment.setStatus(entity.getStatus());
        existingPayment.setReservationConsumerId(entity.getReservationConsumerId());
        return Optional.of(repository.save(existingPayment)).map(paymentConverter::convertToResource).orElseThrow(() -> new RuntimeException("Could not update the payment."));
    }

    @Override
    public PaymentResource get(Long T) {
        return repository.findById(T)
                .map(paymentConverter::convertToResource)
                .orElseThrow(() -> new RuntimeException("Could not find the payment."));
    }
}
