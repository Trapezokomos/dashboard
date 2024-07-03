package net.trapezokomos.dashboard.generator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.*;
import net.trapezokomos.dashboard.security.services.AuthService;
import net.trapezokomos.dashboard.service.*;
import net.trapezokomos.dashboard.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CustomerService customerService;
    private final ConsumerService consumerService;
    private final ReservationTransactionService reservationTransactionService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    @Autowired private UserConverter userConverter;
    @Autowired private CustomerConverter customerConverter;
    @Autowired private ConsumerConverter consumerConverter;
    @Autowired private ReservationTransactionConverter reservationTransactionConverter;
    @Autowired private ReservationConverter reservationConverter;
    @Autowired private PaymentConverter paymentConverter;

    @Override
    public void run(String... args) {
        createUsersData();
        createCustomersData();
        createConsumersData();
        createReservationTransactionsData();
        createReservationsData();
        createPaymentsData();
    }

    private void createUsersData() {
        List<UserResource> list = new ArrayList<>(
                List.of(
                        userConverter.createUserResource( "admin@gmail.com", "Admin first name", "Admin last name", "2310456456", 0, Role.ADMIN, passwordEncoder.encode("password")),
                        userConverter.createUserResource( "customer.admin@gmail.com", "Customer admin first name", "Customer admin last name", "2310159159", 1, Role.CUSTOMER_ADMIN, passwordEncoder.encode("password")),
                        userConverter.createUserResource( "customer.employee@gmail.com", "Customer employee first name", "Customer employee last name", "2310123123", 1, Role.CUSTOMER_EMPLOYEE, passwordEncoder.encode("password"))
                ));
        list.forEach(user -> {
            try {
                authService.register(user);
            } catch (Exception e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createCustomersData() {
        List<CustomerResource> list = new ArrayList<>(
                List.of(
                        customerConverter.createCustomerResource("customer1", "2310567567"),
                        customerConverter.createCustomerResource("customer2", "2310890890")
                )
        );
        list.forEach(customer -> {
            try {
                customerService.save(customer);
            } catch (GenericException e) {
                e.printStackTrace();
            }
        });
    }

    private void createConsumersData() {
        List<ConsumerResource> list = new ArrayList<>(
                List.of(
                        consumerConverter.createConsumerResource("consumer1", "passwordconsumer1", "Consumer1 First Name", "Consumer1 Last Name", "2310345345", "consumer1@gmail.com"),
                        consumerConverter.createConsumerResource("consumer2", "passwordconsumer2", "Consumer2 First Name", "Consumer2 Last Name", "2310890890", "consumer2@gmail.com")
                )
        );
        list.forEach(consumer -> {
            try {
                consumerService.save(consumer);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createReservationTransactionsData() {
        List<ReservationTransactionResource> list = new ArrayList<>(
                List.of(
                        reservationTransactionConverter.createReservationTransactionResource("details1", 10.0, 1L, new Date(), new Date()),
                        reservationTransactionConverter.createReservationTransactionResource("details2", 20.0, 2L, new Date(), new Date())
                )
        );
        list.forEach(reservationTransaction -> {
            try {
                reservationTransactionService.save(reservationTransaction);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createReservationsData() {
        ArrayList<ReservationResource> list = new ArrayList<>(
                List.of(
                        reservationConverter.createReservation(1L, 1L, new Date(), new Date(), new Date(), 10.2, new Date(), "CLOSED"),
                        reservationConverter.createReservation(2L, 3L, new Date(), new Date(), new Date(), 13.2, new Date(), "CANCELLED")
                )
        );
        list.forEach(reservation -> {
            try {
                reservationService.save(reservation);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createPaymentsData() {
        ArrayList<PaymentResource> list = new ArrayList<>(
                List.of(
                        paymentConverter.createPaymentResource(20.2, new Date(), "CLOSED", 1L, new Date(), new Date()),
                        paymentConverter.createPaymentResource(30.2, new Date(), "CANCELLED", 2L, new Date(), new Date())
                )
        );
        list.forEach(payment -> {
            try {
                paymentService.save(payment);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }
}
