package application.repository;

import application.model.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface PerkRepository extends JpaRepository<Perk, Long> {
}
