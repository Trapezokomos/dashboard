package net.trapezokomos.dashboard.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.FeedbackResource;
import net.trapezokomos.dashboard.service.FeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/feedback")
@Tag(name = "Feedback", description = "Basic operations for feedback.")
public class FeedbackControler {
    private final FeedbackService feedbackService;

    public FeedbackControler(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<FeedbackResource>> getFeedback(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(feedbackService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getFeedback(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(feedbackService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createFeedback(@RequestBody FeedbackResource feedbackResource) {
        try {
            return ResponseEntity.ok(feedbackService.save(feedbackResource));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity updateFeedback(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody FeedbackResource feedbackResource
    ) {
        try {
            return ResponseEntity.ok(feedbackService.update(feedbackResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(
            @RequestParam(value = "id", required = true) Long id
    ) {
        feedbackService.delete(id);
    }
}
