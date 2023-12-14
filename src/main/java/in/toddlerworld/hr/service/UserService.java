package in.toddlerworld.hr.service;

import in.toddlerworld.hr.entity.User;
import in.toddlerworld.hr.exception.EntityNotFoundException;
import in.toddlerworld.hr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUser(String username) {
        Optional<User> user = userRepo.findById(username);
        if (user.isPresent()) {
            return user;
        }
        else
            throw new EntityNotFoundException("User not found with the given ID");
    }

    public User updateUser(User user, String username) {
        boolean exists = userRepo.existsById(username);
        if(!exists) {
            throw new EntityNotFoundException("User(username- " + username + ") Not Found !!");
        }
        else
            user.setUsername(username);
        return userRepo.save(user);
    }

    public void deleteUser(String username) {
        boolean exists = userRepo.existsById(username);
        if(!exists) {
            throw new EntityNotFoundException("User(username- " + username + ") Not Found !!");
        }
        else
            userRepo.existsById(username);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }
}
