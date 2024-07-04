package net.trapezokomos.dashboard.generator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.*;
import net.trapezokomos.dashboard.service.*;
import net.trapezokomos.dashboard.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
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
    private final StoreService storeService;
    private final AttributeService attributeService;
    private final BillingDetailsService billingDetailsService;
    private final MenuService menuService;
    private final TablesService tablesService;
    private final StoreDayHourService storeDayHourService;
//    private final ImageService imageService;
    private final FeedbackService feedbackService;

    @Autowired private UserConverter userConverter;
    @Autowired private CustomerConverter customerConverter;
    @Autowired private ConsumerConverter consumerConverter;
    @Autowired private ReservationTransactionConverter reservationTransactionConverter;
    @Autowired private ReservationConverter reservationConverter;
    @Autowired private PaymentConverter paymentConverter;
    @Autowired private StoreConverter storeConverter;
    @Autowired private AttributesConverter attributesConverter;
    @Autowired private BillingDetailsConverter billingDetailsConverter;
    @Autowired private MenuConverter menuConverter;
    @Autowired private TablesConverter tablesConverter;
    @Autowired private StoreDayHourConverter storeDayHourConverter;
//    @Autowired private ImageConverter imageConverter;
    @Autowired private FeedbackConverter feedbackConverter;

    public void run(String... args) {
        createUsersData();
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
//        createImageData();
        createFeedbackData();
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
            } catch (GenericException e) {
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
            } catch (GenericException e) {
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

    private void createStoreData() {
        ArrayList<StoreResource> list = new ArrayList<>(
                List.of(
                        storeConverter.createStoreResource("Store1", "Store1 Address", "Store1 Description", "10:00-12:00", 1, new Date(), new Date()),
                        storeConverter.createStoreResource("Store2", "Store2 Address", "Store2 Description", "12:00-14:00", 2, new Date(), new Date())
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
                      attributesConverter.createAttributeResource("Attribute1", "Attribute1 Description", 1, new Date(), new Date()),
                      attributesConverter.createAttributeResource("Attribute2", "Attribute2 Description", 2, new Date(), new Date())
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
                        billingDetailsConverter.createBillingDetailsResource(1,  new Date(), new Date()),
                        billingDetailsConverter.createBillingDetailsResource(2, new Date(), new Date())
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
                        menuConverter.createMenuResource("Menu1", 1,  new Date(), new Date()),
                        menuConverter.createMenuResource("Menu2", 2, new Date(), new Date())
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
                        tablesConverter.createTablesResource("Table1", "Table1", 1, 4, "Table", true, new Date(), new Date()),
                        tablesConverter.createTablesResource("Table2", "table2", 2, 6, "Table", true, new Date(), new Date())
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
                        storeDayHourConverter.createStoreDayHourResource(1, 1, "monday","Friday",true, new Date(), new Date()),
                        storeDayHourConverter.createStoreDayHourResource(2, 2, "friday","Monday",false, new Date(), new Date())
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

//    private void createImageData() {
//        ArrayList<ImageResource> list = new ArrayList<>(
//                List.of(
////                        imageConverter.createImageResource("Image1", "Image1 Description", 1  ,"http.test.gr",1, new Date(), new Date()),
////                        imageConverter.createImageResource("Image2", "Image2 Description",  "http.test.gr",2, new Date(), new Date())
//                )
//        );
//        list.forEach(image -> {
//            try {
//                imageService.save(image);
//            } catch (GenericException e) {
//                // Handle the exception (e.g., log it, rethrow it as a runtime exception, etc.)
//                e.printStackTrace();
//            }
//        });
//    }
    private void createFeedbackData() {
        ArrayList<FeedbackResource> list = new ArrayList<>(
                List.of(
                        feedbackConverter.createFeedbackResource(1, 1, 1, "test", new Date(), new Date()),
                        feedbackConverter.createFeedbackResource(2, 1, 2, "test2", new Date(), new Date())
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

}
