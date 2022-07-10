package davidctn.licenta.repositories;

import davidctn.licenta.models.Drop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DropRepositoy extends JpaRepository<Drop,Integer> {
}
