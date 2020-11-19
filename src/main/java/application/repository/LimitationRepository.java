package application.repository;

import application.model.Limitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface LimitationRepository extends JpaRepository<Limitation, Long> {
}
