package application.repository;

import application.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "memberships", path = "memberships")
public interface MembershipRepository extends JpaRepository<Membership, Long> {
    Membership findByName(String name);
}
