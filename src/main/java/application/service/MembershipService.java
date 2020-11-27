package application.service;

import application.model.Membership;
import application.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface MembershipService {
    void addMembership(Membership membership);
    List<Membership> findAllMemberships();
    Membership findByName(String name);
    List<Membership> findByUsername(String username);
    List<Membership> findByNotUsername(String username);
}
