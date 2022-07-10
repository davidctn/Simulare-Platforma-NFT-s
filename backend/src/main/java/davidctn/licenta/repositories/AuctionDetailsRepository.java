package davidctn.licenta.repositories;

import davidctn.licenta.models.AuctionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionDetailsRepository extends JpaRepository<AuctionDetails,Integer> {
}
