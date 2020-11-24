package application.service;

import application.model.Membership;
import application.repository.MembershipRepository;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MembershipServiceImpl implements  MembershipService{
    @Autowired
    private MembershipRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addMembership(Membership membership) {
        repository.save(membership);
    }

    @Override
    public List<Membership> findAllMemberships() {
        return repository.findAll();
    }

    @Override
    public Membership findByName(String name) { return repository.findByName(name); }

    @Override
    public List<Membership> findByNotUsername(String username) {
        List<Membership> userMemberships = new ArrayList<Membership>(userRepository.findByUsername(username).getMemberships());
        List<Membership> allMemberships = new ArrayList<Membership>(repository.findAll());
        allMemberships.removeAll(userMemberships);
        return allMemberships;
    }
}
