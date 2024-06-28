package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.resources.UserResource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class UserConverter implements AbstractConverter<UserResource, User> {

    @Override
    public UserResource convertToResource(User user) {
        UserResource userResource = new UserResource();
        userResource.setId(user.getId());
        userResource.setUsername(user.getUsername());
        userResource.setEmail(user.getEmail());
        userResource.setFirst_name(user.getFirstName());
        userResource.setLast_name(user.getLastName());
        userResource.setPhone_number(user.getPhoneNumber());
        userResource.setCustomerId(user.getCustomerId());
        userResource.setRoles(user.getRoles());
        userResource.setCreatedAt(user.getCreatedAt());
        userResource.setUpdatedAt(user.getUpdatedAt());
        return userResource;
    }

    @Override
    public User convertToEntity(UserResource userResource) {
        User user = new User();
        user.setId(userResource.getId());
        user.setUsername(userResource.getUsername());
        user.setEmail(userResource.getEmail());
        user.setFirstName(userResource.getFirst_name());
        user.setLastName(userResource.getLast_name());
        user.setPhoneNumber(userResource.getPhone_number());
        user.setCustomerId(userResource.getCustomerId());
        user.setRoles(userResource.getRoles());
        user.setCreatedAt(userResource.getCreatedAt());
        user.setUpdatedAt(userResource.getUpdatedAt());
        return user;
    }

    public UserResource createUserResource(String username, String email, String first_name, String last_name, String phone_number, int customerId, Set<Role> roles, Date createdAt, Date updatedAt) {
        UserResource userResource = new UserResource();
        userResource.setUsername(username);
        userResource.setEmail(email);
        userResource.setFirst_name(first_name);
        userResource.setLast_name(last_name);
        userResource.setPhone_number(phone_number);
        userResource.setCustomerId(customerId);
        userResource.setRoles(roles);
        userResource.setCreatedAt(createdAt);
        userResource.setUpdatedAt(updatedAt);
        return userResource;
    }
}
