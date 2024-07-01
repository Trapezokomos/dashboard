package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.resources.UserResource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class UserConverter implements AttributeConverter<UserResource, User> {

    @Override
    public User convertToDatabaseColumn(UserResource userResource) {
        return User.builder()
                .id(userResource.getId())
                .customerId(userResource.getCustomerId())
                .email(userResource.getEmail())
                .firstName(userResource.getFirst_name())
                .lastName(userResource.getLast_name())
                .phoneNumber(userResource.getPhone_number())
                .roles(userResource.getRoles())
                .username(userResource.getUsername())
                .createdAt(userResource.getCreatedAt())
                .updatedAt(userResource.getUpdatedAt())
                .build();
    }

    @Override
    public UserResource convertToEntityAttribute(User user) {
        return UserResource.builder()
                .id(user.getId())
                .customerId(user.getCustomerId())
                .email(user.getEmail())
                .first_name(user.getFirstName())
                .last_name(user.getLastName())
                .phone_number(user.getPhoneNumber())
                .roles(user.getRoles())
                .username(user.getUsername())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserResource createUserResource(String username, String email, String first_name, String last_name, String phone_number, int customerId, Set<Role> roles, Date createdAt, Date updatedAt) {
        return UserResource.builder()
                .customerId(customerId)
                .email(email)
                .first_name(first_name)
                .last_name(last_name)
                .phone_number(phone_number)
                .roles(roles)
                .username(username)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
