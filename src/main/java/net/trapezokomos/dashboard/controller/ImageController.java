package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.ImageResource;
import net.trapezokomos.dashboard.service.ImageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/image")
@Tag(name = "Image", description = "Basic operations for images.")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/all")
    public ResponseEntity<Page<ImageResource>> getImages(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(imageService.list(PageRequest.of(pageNumber, pageSize)));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ImageResource> getImage(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(imageService.get(id));
    }

    @PostMapping
    public ResponseEntity<ImageResource> createImage(@RequestBody ImageResource imageResource) throws GenericException {
        return ResponseEntity.ok(imageService.save(imageResource));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageResource> updateImage(
            @PathVariable(value = "id") Long id,
            @RequestBody ImageResource imageResource
    ) {
        return ResponseEntity.ok(imageService.update(imageResource, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(
            @PathVariable(value = "id") Long id
    ) {
        imageService.delete(id);
        return ResponseEntity.ok().build();
    }
}
