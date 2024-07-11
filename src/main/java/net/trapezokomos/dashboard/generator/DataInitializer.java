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

    private final UserService userService;
    private final CustomerService customerService;
    private final ConsumerService consumerService;
    private final ReservationTransactionService reservationTransactionService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;
    private final StoreService storeService;
    private final AttributeService attributeService;
    private final BillingDetailsService billingDetailsService;
    private final MenuService menuService;
    private final TablesService tablesService;
    private final StoreDayHourService storeDayHourService;
    private final FeedbackService feedbackService;

    @Autowired
    private UserConverter userConverter;
    @Autowired
    private CustomerConverter customerConverter;
    @Autowired
    private ConsumerConverter consumerConverter;
    @Autowired
    private ReservationTransactionConverter reservationTransactionConverter;
    @Autowired
    private ReservationConverter reservationConverter;
    @Autowired
    private PaymentConverter paymentConverter;
    @Autowired
    private StoreConverter storeConverter;
    @Autowired
    private AttributesConverter attributesConverter;
    @Autowired
    private BillingDetailsConverter billingDetailsConverter;
    @Autowired
    private MenuConverter menuConverter;
    @Autowired
    private TablesConverter tablesConverter;
    @Autowired
    private StoreDayHourConverter storeDayHourConverter;
    @Autowired
    private FeedbackConverter feedbackConverter;

    @Override
    public void run(String... args) {
        registerUsersData();
        createCustomersData();
        createConsumersData();
        createReservationTransactionsData();
        createReservationsData();
        createPaymentsData();
        createStoreData();
        createAttributeData();
        createBillingDetailsData();
        createMenuData();
        createTablesData();
        createStoreDayHourData();
        createFeedbackData();
    }

    private void registerUsersData() {
        List<UserResource> list = new ArrayList<>(
                List.of(
                        userConverter.createUserResource("admin@gmail.com", "Admin first name", "Admin last name", "2310456456", 0, Role.ADMIN, passwordEncoder.encode("password")),
                        userConverter.createUserResource("customer.admin@gmail.com", "Customer admin first name", "Customer admin last name", "2310159159", 1, Role.CUSTOMER_ADMIN, passwordEncoder.encode("password")),
                        userConverter.createUserResource("customer.employee@gmail.com", "Customer employee first name", "Customer employee last name", "2310123123", 1, Role.CUSTOMER_EMPLOYEE, passwordEncoder.encode("password"))
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
                        reservationTransactionConverter.createReservationTransactionResource("details1", 10.0, 1L),
                        reservationTransactionConverter.createReservationTransactionResource("details2", 20.0, 2L)
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
                        reservationConverter.createReservation(1L, 1L, new Date(), new Date(), new Date(), 10.2, "CLOSED"),
                        reservationConverter.createReservation(2L, 3L, new Date(), new Date(), new Date(), 13.2, "CANCELLED")
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
                        paymentConverter.createPaymentResource(20.2, new Date(), "CLOSED", 1L),
                        paymentConverter.createPaymentResource(30.2, new Date(), "CANCELLED", 2L)
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

    private void createStoreData() {
        ArrayList<StoreResource> list = new ArrayList<>(
                List.of(
                        storeConverter.createStoreResource("Store1", "Store1 Address", "Store1 Description", "10:00-12:00", 1),
                        storeConverter.createStoreResource("Store2", "Store2 Address", "Store2 Description", "12:00-14:00", 2)
                )
        );
        list.forEach(store -> {
            try {
                storeService.save(store);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createAttributeData() {
        ArrayList<AttributeResource> list = new ArrayList<>(
                List.of(
                        attributesConverter.createAttributeResource("Attribute1", "Attribute1 Description", 1, "value"),
                        attributesConverter.createAttributeResource("Attribute2", "Attribute2 Description", 2, "value")
                )
        );
        list.forEach(attribute -> {
            try {
                attributeService.save(attribute);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });

    }

    private void createBillingDetailsData() {
        ArrayList<BillingDetailsResource> list = new ArrayList<>(
                List.of(
                        billingDetailsConverter.createBillingDetailsResource(1),
                        billingDetailsConverter.createBillingDetailsResource(2)
                )
        );
        list.forEach(billingDetails -> {
            try {
                billingDetailsService.save(billingDetails);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createMenuData() {
        ArrayList<MenuResource> list = new ArrayList<>(
                List.of(
                        menuConverter.createMenuResource("Menu1", 1),
                        menuConverter.createMenuResource("Menu2", 2)
                )
        );
        list.forEach(menu -> {
            try {
                menuService.save(menu);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createTablesData() {
        ArrayList<TablesResource> list = new ArrayList<>(
                List.of(
                        tablesConverter.createTablesResource("Table1", "Table1", 1, 4, "Table", true),
                        tablesConverter.createTablesResource("Table2", "table2", 2, 6, "Table", true)
                )
        );
        list.forEach(tables -> {
            try {
                tablesService.save(tables);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createStoreDayHourData() {
        ArrayList<StoreDayHourResource> list = new ArrayList<>(
                List.of(
                        storeDayHourConverter.createStoreDayHourResource(1, 1, "monday", "Friday", true),
                        storeDayHourConverter.createStoreDayHourResource(2, 2, "friday", "Monday", false)
                )
        );
        list.forEach(storeDayHour -> {
            try {
                storeDayHourService.save(storeDayHour);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    private void createFeedbackData() {
        ArrayList<FeedbackResource> list = new ArrayList<>(
                List.of(
                        feedbackConverter.createFeedbackResource(1, 1, 1, "test", new Date()),
                        feedbackConverter.createFeedbackResource(2, 1, 2, "test2", new Date())
                )
        );
        list.forEach(feedback -> {
            try {
                feedbackService.save(feedback);
            } catch (GenericException e) {
                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                e.printStackTrace();
            }
        });
    }

    // TODO: Implement createImageData
    /**    private void createImageData() {
            ArrayList<ImageResource> list = new ArrayList<>(
                    List.of(
                           imageConverter.createImageResource("Image1", "Image1 Description", 1  ,"http.test.gr",1, new Date(), new Date()),
                           imageConverter.createImageResource("Image2", "Image2 Description",  "http.test.gr",2, new Date(), new Date())
                    )
            );
            list.forEach(image -> {
                try {
                    imageService.save(image);
                } catch (GenericException e) {
                    // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
                    e.printStackTrace();
                }
            });
        } **/
}
