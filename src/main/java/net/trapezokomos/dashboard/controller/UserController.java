package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.trapezokomos.dashboard.exception.GenericException;
import net.trapezokomos.dashboard.resources.UserResource;
import net.trapezokomos.dashboard.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "Basic operations for users.")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<Page<UserResource>> getUsers(
            @RequestParam(value = "pageNumber") Integer pageNumber,
            @RequestParam(value = "pageSize") Integer pageSize
    ) {
        return ResponseEntity.ok(userService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUser(
            @PathVariable(value = "id") Long id
    ) {
        return ResponseEntity.ok(userService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(
            @PathVariable(value = "id") Long id,
            @RequestBody UserResource userResource
    ) {
        return ResponseEntity.ok(userService.update(userResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable(value = "id") Long id
    ) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<UserResource> createUser(@RequestBody @Valid UserResource userResource) throws GenericException {
        return ResponseEntity.ok(userService.save(userResource));
    }

    // Search operation for future usage.
    //    @GetMapping("/search")
    //    public ResponseEntity<List<UserResource>> searchUser(
    //            @PathVariable(value = "filterText", required = true) String filterText
    //    ) {
    //        return ResponseEntity.ok(userService.search(filterText));
    //    }
}
