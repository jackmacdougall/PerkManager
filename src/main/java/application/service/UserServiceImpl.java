package application.service;

import application.model.Membership;
import application.model.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    public Optional<User> findById(Long id) {
        return repository.findById(Math.toIntExact(id));
    }

    public User findByUsername(String username) { return repository.findByUsername(username); }
}
