package application.service;

import application.model.Membership;
import application.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MembershipService {
    public void save(Membership membership);
    public List<Membership> findAllMemberships();
    public Membership findByName(String name);
}
