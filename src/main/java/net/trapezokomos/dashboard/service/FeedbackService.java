package net.trapezokomos.dashboard.service;

import net.trapezokomos.dashboard.data.Feedback;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.exception.GenericRunTimeException;
import net.trapezokomos.dashboard.repository.FeedbackRepository;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import net.trapezokomos.dashboard.utils.FeedbackConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService implements BaseService<FeedbackResource> {
    private final FeedbackRepository repository;
    @Autowired private FeedbackConverter feedbackConverter;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    @Override
    public FeedbackResource save(FeedbackResource entity) throws GenericException {
        Feedback feedback = feedbackConverter.convertToDatabaseColumn(entity);
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
        existingFeedback.setStore_id(entity.getStore_id());
        existingFeedback.setCreatedAt(entity.getCreatedAt());
        existingFeedback.setUpdatedAt(entity.getUpdatedAt());
        return feedbackConverter.convertToEntityAttribute(repository.save(existingFeedback));
    }
}