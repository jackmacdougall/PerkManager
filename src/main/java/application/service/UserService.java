package application.service;

import application.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    public Optional<User> findById(Long id);
    public User findByUsername(String username);
}
