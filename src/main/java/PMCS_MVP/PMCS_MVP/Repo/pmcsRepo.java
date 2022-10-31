package PMCS_MVP.PMCS_MVP.Repo;

import PMCS_MVP.PMCS_MVP.Model.pmcs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pmcsRepo extends JpaRepository<pmcs, Long> {
    String test = "";
}
