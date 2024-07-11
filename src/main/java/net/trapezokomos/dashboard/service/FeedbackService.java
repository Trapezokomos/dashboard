package net.trapezokomos.dashboard.service;

import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.data.Feedback;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.FeedbackRepository;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import net.trapezokomos.dashboard.utils.FeedbackConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedbackService implements BaseService<FeedbackResource> {

    private final FeedbackRepository repository;
    private final FeedbackConverter feedbackConverter;

    @Override
    public FeedbackResource save(FeedbackResource entity) throws GenericException {
        Feedback feedback = feedbackConverter.convertToDatabaseColumn(entity);
        feedback.setCreatedAt(new Date());
        feedback.setUpdatedAt(new Date());
        return Optional.of(repository.save(feedback)).map(feedbackConverter::convertToEntityAttribute).orElseThrow(() -> new GenericRunTimeException("Could not create the feedback."));
    }

    @Override
    public void delete(Long id) {
        Feedback existingFeedback = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the feedback."));
        repository.delete(existingFeedback);
    }

    @Override
    public Page<FeedbackResource> list(Pageable pageable) {
        return repository.findAll(pageable).map(feedbackConverter::convertToEntityAttribute);
    }

    public FeedbackResource get(Long id) {
        return repository.findById(id)
                .map(feedbackConverter::convertToEntityAttribute)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the feedback."));
    }

    @Override
    public FeedbackResource update(FeedbackResource entity, Long id) {
        Feedback existingFeedback = repository.findById(id)
                .orElseThrow(() -> new GenericRunTimeException("Could not find the feedback."));
        existingFeedback.setStoreId(entity.getStoreId());
        existingFeedback.setUserId(entity.getUserId());
        existingFeedback.setRating(entity.getRating());
        existingFeedback.setComment(entity.getComment());
        existingFeedback.setDate(entity.getDate());
        existingFeedback.setUpdatedAt(entity.getUpdatedAt());
        return feedbackConverter.convertToEntityAttribute(repository.save(existingFeedback));
    }
}