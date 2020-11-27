package application.repository;

import application.model.Limitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "limitations", path = "limitations")
public interface LimitationRepository extends JpaRepository<Limitation, Long> {
    List<Limitation> findByPerkId(Long id);
}
