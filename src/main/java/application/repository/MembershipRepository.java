package application.repository;

import application.model.Membership;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "memberships", path = "memberships")
public interface MembershipRepository extends CrudRepository<Membership, Integer> {
}
