package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Role;
import net.trapezokomos.dashboard.data.User;
import net.trapezokomos.dashboard.resources.UserResource;
import org.springframework.stereotype.Component;

@Component
@Converter
public class UserConverter implements AttributeConverter<UserResource, User> {

    @Override
    public User convertToDatabaseColumn(UserResource userResource) {
        return User.builder()
                .firstName(userResource.getFirstName())
                .lastName(userResource.getLastName())
                .email(userResource.getEmail())
                .phoneNumber(userResource.getPhoneNumber())
                .role(userResource.getRole())
                .customerId(userResource.getCustomerId())
                .password(userResource.getPassword())
                .id(userResource.getId())
                .createdAt(userResource.getCreatedAt())
                .updatedAt(userResource.getUpdatedAt())
                .version(userResource.getVersion())
                .build();
    }

    @Override
    public UserResource convertToEntityAttribute(User user) {
        return UserResource.builder()
                .id(user.getId())
                .customerId(user.getCustomerId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .password(user.getPassword())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .version(user.getVersion())
                .build();
    }

    public UserResource createUserResource(String email, String first_name, String last_name, String phone_number, int customerId, Role role, String password) {
        return UserResource.builder()
                .customerId(customerId)
                .password(password)
                .email(email)
                .firstName(first_name)
                .lastName(last_name)
                .phoneNumber(phone_number)
                .role(role)
                .version(1)
                .build();
    }
}
