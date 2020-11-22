package application.service;

import application.model.Membership;
import application.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface MembershipService {
    public void save(Membership membership);
    public List<Membership> findAllMemberships();
    public Membership findByName(String name);
    public List<Membership> findByNotUsername(String username);
}
