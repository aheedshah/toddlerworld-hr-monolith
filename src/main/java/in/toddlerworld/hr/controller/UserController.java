package in.toddlerworld.hr.controller;

import in.toddlerworld.hr.entity.User;
import in.toddlerworld.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user ) {
        return  ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/user/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String username) {
        return  ResponseEntity.ok(userService.updateUser(user,username));
    }

    @DeleteMapping("/user/{username}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String username) {
        Map<String, String> responseMap = new TreeMap<>(Collections.reverseOrder());
        userService.deleteUser(username);
        String msg = "The record has been deleted !!";
        responseMap.put("user_ username", username);
        responseMap.put("message_response", msg);
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }
}
