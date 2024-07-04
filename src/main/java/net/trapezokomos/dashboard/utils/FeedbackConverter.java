package net.trapezokomos.dashboard.utils;

import jakarta.persistence.AttributeConverter;
import net.trapezokomos.dashboard.data.Feedback;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class FeedbackConverter implements AttributeConverter<FeedbackResource, Feedback> {

    @Override
    public Feedback convertToDatabaseColumn(FeedbackResource feedbackResource) {
        return Feedback.builder()
                .user_id(feedbackResource.getUser_id())
                .store_id(feedbackResource.getStore_id())
                .rating(feedbackResource.getRating())
                .comment(feedbackResource.getComments())
                .createdAt(feedbackResource.getCreatedAt())
                .updatedAt(feedbackResource.getUpdatedAt())
                .build();
    }
    @Override
    public FeedbackResource convertToEntityAttribute(Feedback feedback) {
        return FeedbackResource.builder()
                .user_id(feedback.getUser_id())
                .store_id(feedback.getStore_id())
                .rating(feedback.getRating())
                .comments(feedback.getComment())
                .createdAt(feedback.getCreatedAt())
                .updatedAt(feedback.getUpdatedAt())
                .build();
    }

    public FeedbackResource createFeedbackResource(int user_id, int store_id, int rating, String comments, Date createdAt, Date updatedAt) {
        return FeedbackResource.builder()
                .user_id(user_id)
                .store_id(store_id)
                .rating(rating)
                .comments(comments)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
