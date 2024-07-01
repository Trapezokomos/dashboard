package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Consumer;
import net.trapezokomos.dashboard.resources.ConsumerResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsumerConverter implements AttributeConverter<ConsumerResource, Consumer> {

    @Override
    public Consumer convertToDatabaseColumn(ConsumerResource consumerResource) {
        return Consumer.builder()
                .id(consumerResource.getId())
                .email(consumerResource.getEmail())
                .firstName(consumerResource.getFirstName())
                .lastName(consumerResource.getLastName())
                .phoneNumber(consumerResource.getPhoneNumber())
                .username(consumerResource.getUsername())
                .password(consumerResource.getPassword())
                .createdAt(consumerResource.getCreatedAt())
                .updatedAt(consumerResource.getUpdatedAt())
                .build();
    }

    @Override
    public ConsumerResource convertToEntityAttribute(Consumer consumer) {
        return ConsumerResource.builder()
                .id(consumer.getId())
                .email(consumer.getEmail())
                .firstName(consumer.getFirstName())
                .lastName(consumer.getLastName())
                .phoneNumber(consumer.getPhoneNumber())
                .username(consumer.getUsername())
                .password(consumer.getPassword())
                .createdAt(consumer.getCreatedAt())
                .updatedAt(consumer.getUpdatedAt())
                .build();
    }

    public ConsumerResource createConsumerResource(String username, String password, String firstName, String lastName, String phoneNumber, String email, Date createdAt, Date updatedAt) {
        return ConsumerResource.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .username(username)
                .password(password)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
