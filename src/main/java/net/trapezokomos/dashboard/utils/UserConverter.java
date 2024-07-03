package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.resources.UserResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserConverter implements AttributeConverter<UserResource, User> {

    @Override
    public User convertToDatabaseColumn(UserResource userResource) {
        return (User) User.builder()
                .firstName(userResource.getFirst_name())
                .lastName(userResource.getLast_name())
                .email(userResource.getEmail())
                .phoneNumber(userResource.getPhone_number())
                .role(userResource.getRole())
                .id(userResource.getId())
                .customerId(userResource.getCustomerId())
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
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public UserResource createUserResource(String email, String first_name, String last_name, String phone_number, int customerId, Role role, Date createdAt, Date updatedAt) {
        return UserResource.builder()
                .customerId(customerId)
                .email(email)
                .first_name(first_name)
                .last_name(last_name)
                .phone_number(phone_number)
                .role(role)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
