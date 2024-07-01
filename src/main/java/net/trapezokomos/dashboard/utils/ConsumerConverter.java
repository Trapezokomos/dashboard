package net.trapezokomos.dashboard.utils;

import net.trapezokomos.dashboard.data.Consumer;
import net.trapezokomos.dashboard.resources.ConsumerResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsumerConverter implements BaseConverter<ConsumerResource, Consumer> {
    @Override
    public ConsumerResource convertToResource(Consumer consumer) {
        ConsumerResource consumerResource = new ConsumerResource();
        consumerResource.setId(consumer.getId());
        consumerResource.setUsername(consumer.getUsername());
        consumerResource.setPassword(consumer.getPassword());
        consumerResource.setFirstName(consumer.getFirstName());
        consumerResource.setLastName(consumer.getLastName());
        consumerResource.setPhoneNumber(consumer.getPhoneNumber());
        consumerResource.setEmail(consumer.getEmail());
        consumerResource.setCreatedAt(consumer.getCreatedAt());
        consumerResource.setUpdatedAt(consumer.getUpdatedAt());
        return consumerResource;
    }

    @Override
    public Consumer convertToEntity(ConsumerResource consumerResource) {
        Consumer consumer = new Consumer();
        consumer.setId(consumerResource.getId());
        consumer.setUsername(consumerResource.getUsername());
        consumer.setPassword(consumerResource.getPassword());
        consumer.setFirstName(consumerResource.getFirstName());
        consumer.setLastName(consumerResource.getLastName());
        consumer.setPhoneNumber(consumerResource.getPhoneNumber());
        consumer.setEmail(consumerResource.getEmail());
        consumer.setCreatedAt(consumerResource.getCreatedAt());
        consumer.setUpdatedAt(consumerResource.getUpdatedAt());
        return consumer;
    }

    public ConsumerResource createConsumerResource(String username, String password, String firstName, String lastName, String phoneNumber, String email, Date createdAt, Date updatedAt) {
        ConsumerResource consumerResource = new ConsumerResource();
        consumerResource.setUsername(username);
        consumerResource.setPassword(password);
        consumerResource.setFirstName(firstName);
        consumerResource.setLastName(lastName);
        consumerResource.setPhoneNumber(phoneNumber);
        consumerResource.setEmail(email);
        consumerResource.setCreatedAt(createdAt);
        consumerResource.setUpdatedAt(updatedAt);
        return consumerResource;
    }
}
