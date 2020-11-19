package application.repository;

import application.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembershipRepository extends JpaRepository<Membership, Long> {
}
