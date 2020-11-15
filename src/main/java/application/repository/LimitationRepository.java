package application.repository;

import application.model.Limitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "limitations", path = "limitations")
public interface LimitationRepository extends CrudRepository<Limitation, Integer> {
}
