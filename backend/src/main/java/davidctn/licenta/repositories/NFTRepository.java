package davidctn.licenta.repositories;

import davidctn.licenta.models.NFT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NFTRepository extends JpaRepository<NFT,Integer> {
}
