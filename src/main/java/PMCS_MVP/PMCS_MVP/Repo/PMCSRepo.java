package PMCS_MVP.PMCS_MVP.Repo;

import PMCS_MVP.PMCS_MVP.Model.PMCS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PMCSRepo extends JpaRepository<PMCS, Long> {

        List<PMCS> findByItemNameContaining(String itemName);
}
