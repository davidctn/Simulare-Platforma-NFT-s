package davidctn.licenta.repositories;

import davidctn.licenta.models.Trait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends JpaRepository<Trait,Integer> {
}
