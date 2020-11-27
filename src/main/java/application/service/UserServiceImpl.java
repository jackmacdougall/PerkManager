package application.service;

import application.model.Membership;
import application.model.User;
import application.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public User findById(Long id) throws Exception {
        Optional<User> fetchedUser = repository.findById(Math.toIntExact(id));
        if(fetchedUser.isPresent()) return fetchedUser.get();
        else throw new Exception("user not found");
    }

    public User findByUsername(String username) { return repository.findByUsername(username); }

    public void addMembershipToUser(String userData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(userData);
            User user = mapper.convertValue(node.get("userObj"), User.class);
            Membership membership = mapper.convertValue(node.get("membershipObj"), Membership.class);
            user.addMembership(membership);
            save(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void addNewMembershipToUser(String userData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(userData);
            User user = mapper.convertValue(node.get("userObj"), User.class);
            String membershipName = mapper.convertValue(node.get("membershipName"), String.class);
            Membership membership = new Membership(membershipName);
            user.addMembership(membership);
            save(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
