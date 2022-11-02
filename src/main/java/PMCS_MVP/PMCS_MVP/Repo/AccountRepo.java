package PMCS_MVP.PMCS_MVP.Repo;

import PMCS_MVP.PMCS_MVP.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long>
{
    //Looks For the account with the right username
    Account findByUsername(String name);
    Boolean existsByUsername(String name);

}
