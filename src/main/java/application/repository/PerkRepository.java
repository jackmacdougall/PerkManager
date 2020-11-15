package application.repository;

import application.model.Perk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "perks", path = "perks")
public interface PerkRepository extends CrudRepository<Perk, Integer> {
}
