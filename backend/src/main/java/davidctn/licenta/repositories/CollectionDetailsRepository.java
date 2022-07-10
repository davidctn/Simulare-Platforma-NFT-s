package davidctn.licenta.repositories;

import davidctn.licenta.models.CollectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionDetailsRepository extends JpaRepository<CollectionDetails,Integer> {
}
