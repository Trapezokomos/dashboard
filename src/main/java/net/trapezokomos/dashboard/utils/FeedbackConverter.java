package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.trapezokomos.dashboard.data.Feedback;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Converter
public class FeedbackConverter implements AttributeConverter<FeedbackResource, Feedback> {

    @Override
    public Feedback convertToDatabaseColumn(FeedbackResource feedbackResource) {
        return Feedback.builder()
                .userId(feedbackResource.getUserId())
                .storeId(feedbackResource.getStoreId())
                .rating(feedbackResource.getRating())
                .comment(feedbackResource.getComment())
                .date(feedbackResource.getDate())
                .createdAt(feedbackResource.getCreatedAt())
                .updatedAt(feedbackResource.getUpdatedAt())
                .build();
    }

    @Override
    public FeedbackResource convertToEntityAttribute(Feedback feedback) {
        return FeedbackResource.builder()
                .userId(feedback.getUserId())
                .storeId(feedback.getStoreId())
                .rating(feedback.getRating())
                .comment(feedback.getComment())
                .date(feedback.getDate())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }

    public FeedbackResource createFeedbackResource(int user_id, int store_id, int rating, String comment, Date date) {
        return FeedbackResource.builder()
                .userId(user_id)
                .storeId(store_id)
                .rating(rating)
                .comment(comment)
                .date(date)
                .build();
    }
}
