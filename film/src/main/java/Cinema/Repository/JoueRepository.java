package Cinema.Repository;

import Cinema.Entities.Joue;
import Cinema.Entities.JoueKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueRepository extends JpaRepository<Joue, JoueKey>{
}
