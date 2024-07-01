package net.trapezokomos.dashboard.generator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.resources.*;
import net.trapezokomos.dashboard.service.*;
import net.trapezokomos.dashboard.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;
    private final CustomerService customerService;
    private final ConsumerService consumerService;
    private final ReservationTransactionService reservationTransactionService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;

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
                        userConverter.createUserResource("admin", "admin@gmail.com", "Admin first name", "Admin last name", "2310456456", 0, Set.of(Role.ADMIN), new Date(), new Date()),
                        userConverter.createUserResource("customeradmin", "customer.admin@gmail.com", "Customer admin first name", "Customer admin last name", "2310159159", 1, Set.of(Role.CUSTOMER_ADMIN), new Date(), new Date()),
                        userConverter.createUserResource("customeremployee", "customer.employee@gmail.com", "Customer employee first name", "Customer employee last name", "2310123123", 1, Set.of(Role.CUSTOMER_EMPLOYEE), new Date(), new Date()),
                        userConverter.createUserResource("customeremployeeandadmin", "customer.employeeandadmin@gmail.com", "Customer employee and admin first name", "Customer employee and admin last name", "2310258258", 1, Set.of(Role.CUSTOMER_EMPLOYEE, Role.CUSTOMER_ADMIN), new Date(), new Date())
                ));
        list.forEach(user -> {
            try {
                userService.save(user);
            } catch (ResourceAlreadyExistsException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createCustomersData() {
        List<CustomerResource> list = new ArrayList<>(
                List.of(
                        customerConverter.createCustomerResource("customer1", "2310567567", new Date(), new Date()),
                        customerConverter.createCustomerResource("customer2", "2310890890", new Date(), new Date())
                )
        );
        list.forEach(customer -> {
            try {
                customerService.save(customer);
            } catch (ResourceAlreadyExistsException e) {
                e.printStackTrace();
            }
        });
    }

    private void createConsumersData() {
        List<ConsumerResource> list = new ArrayList<>(
                List.of(
                        consumerConverter.createConsumerResource("consumer1", "passwordconsumer1", "Consumer1 First Name", "Consumer1 Last Name", "2310345345", "consumer1@gmail.com", new Date(), new Date()),
                        consumerConverter.createConsumerResource("consumer2", "passwordconsumer2", "Consumer2 First Name", "Consumer2 Last Name", "2310890890", "consumer2@gmail.com", new Date(), new Date())
                )
        );
        list.forEach(consumer -> {
            try {
                consumerService.save(consumer);
            } catch (ResourceAlreadyExistsException e) {
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
            } catch (ResourceAlreadyExistsException e) {
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
            } catch (ResourceAlreadyExistsException e) {
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
            } catch (ResourceAlreadyExistsException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }
}
