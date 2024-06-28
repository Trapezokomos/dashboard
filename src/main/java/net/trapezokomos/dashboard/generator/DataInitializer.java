package net.trapezokomos.dashboard.generator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.exception.ResourceAlreadyExistsException;
import net.trapezokomos.dashboard.resources.UserResource;
import net.trapezokomos.dashboard.service.UserService;
import net.trapezokomos.dashboard.utils.UserConverter;
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
    @Autowired
    private UserConverter userConverter;

    @Override
    public void run(String... args) {
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
}
