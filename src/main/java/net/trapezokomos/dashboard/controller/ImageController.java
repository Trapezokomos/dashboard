package net.trapezokomos.dashboard.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import net.trapezokomos.dashboard.resources.ImageResource;
import net.trapezokomos.dashboard.service.ImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image")
@Tag(name = "Image", description = "Basic operations for images.")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ImageResource>> getImages(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(imageService.list(PageRequest.of(pageNumber, pageSize)));
    }


    @GetMapping("/{id}")
    public ResponseEntity getImage(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(imageService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createImage(@RequestBody ImageResource imageResource) {
        try {
            return ResponseEntity.ok(imageService.save(imageResource));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateImage(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody ImageResource imageResource
    ) {
        try {
            return ResponseEntity.ok(imageService.update(imageResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteImage(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            imageService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }
}
