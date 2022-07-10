package davidctn.licenta.repositories;

import davidctn.licenta.models.DropDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropDetailsRepository extends JpaRepository<DropDetails,Integer> {
}
