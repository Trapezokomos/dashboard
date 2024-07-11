package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import net.trapezokomos.dashboard.service.FeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/feedback")
@Tag(name = "Feedback", description = "Basic operations for feedback.")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @GetMapping("/all")
    public ResponseEntity<Page<FeedbackResource>> getFeedback(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(feedbackService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackResource> getFeedback(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(feedbackService.get(id));
    }

    @PostMapping
    public ResponseEntity<FeedbackResource> createFeedback(@RequestBody FeedbackResource feedbackResource) throws GenericException {
        return ResponseEntity.ok(feedbackService.save(feedbackResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackResource> updateFeedback(
            @PathVariable(value = "id") Long id,
            @RequestBody FeedbackResource feedbackResource
    ) {
        return ResponseEntity.ok(feedbackService.update(feedbackResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FeedbackResource> deleteFeedback(
            @PathVariable(value = "id") Long id
    ) {
        feedbackService.delete(id);
        return ResponseEntity.ok().build();
    }
}
