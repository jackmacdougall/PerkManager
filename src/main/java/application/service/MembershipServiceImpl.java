package application.service;

import application.model.Membership;
import application.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements  MembershipService{
    @Autowired
    private MembershipRepository repository;

    @Override
    public void save(Membership membership) {
        repository.save(membership);
    }

    @Override
    public List<Membership> findAllMemberships() {
        return repository.findAll();
    }

    @Override
    public Membership findByName(String name) { return repository.findByName(name); }
}
