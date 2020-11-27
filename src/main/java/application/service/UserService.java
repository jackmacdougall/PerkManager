package application.service;

import application.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {
    void save(User user);
    User findById(Long id) throws Exception;
    User findByUsername(String username);
    void addMembershipToUser(String userData);
    void addNewMembershipToUser(String userData);
}
