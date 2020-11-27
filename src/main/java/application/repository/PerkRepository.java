package application.repository;

import application.model.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "perks", path = "perks")
public interface PerkRepository extends JpaRepository<Perk, Long> {
}
