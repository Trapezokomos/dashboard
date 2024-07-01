package net.trapezokomos.dashboard.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import net.trapezokomos.dashboard.resources.UserResource;
import net.trapezokomos.dashboard.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Basic operations for users.")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<Page<UserResource>> getUsers(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(userService.list(PageRequest.of(pageNumber, pageSize)));
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            return ResponseEntity.ok(userService.get(id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserResource userResource) {
        try {
            return ResponseEntity.ok(userService.save(userResource));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(
            @RequestParam(value = "id", required = true) Long id,
            @RequestBody UserResource userResource
    ) {
        try {
            return ResponseEntity.ok(userService.update(userResource, id));
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(
            @RequestParam(value = "id", required = true) Long id
    ) {
        try {
            userService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    //    @GetMapping("/search")
//    public ResponseEntity<List<UserResource>> searchUser(
//            @RequestParam(value = "filterText", required = true) String filterText
//    ) {
//        return ResponseEntity.ok(userService.search(filterText));
//    }
}
