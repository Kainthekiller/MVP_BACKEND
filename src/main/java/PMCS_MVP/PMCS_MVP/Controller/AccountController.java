package PMCS_MVP.PMCS_MVP.Controller;

import PMCS_MVP.PMCS_MVP.Model.Account;
import PMCS_MVP.PMCS_MVP.Repo.AccountRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Account")
public class AccountController {

    AccountRepo accountRepo;

    //Constructor
    AccountController(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


    //Post Account
    @PostMapping("")
    ResponseEntity<Account> createAccount(@RequestBody Account body) {
        return new ResponseEntity<>(accountRepo.save(body), HttpStatus.OK);
    }

    //Need To Get By Username
    @GetMapping("/LookUpAccount/{userName}/{password}")
    ResponseEntity<Account> validateAccount(@PathVariable String userName, @PathVariable String password) {

        //Checks If The Account Exist
        if (accountRepo.existsByUsername(userName)) {
            //Account exist check if password is correct
            if (accountRepo.findByUsername(userName).getPassword().equals(password)) {
                //Account is Authenticated
                return new ResponseEntity<>(accountRepo.findByUsername(userName), HttpStatus.OK);
            } else {
                //Incorrect Password
                return new ResponseEntity<>(accountRepo.findByUsername(userName), HttpStatus.NOT_ACCEPTABLE);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @GetMapping("")
    List<Account> getAllUsers()
    {
        return accountRepo.findAll();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Account> deleteAccount(@PathVariable Long id)
    {
        if (accountRepo.findById(id).isPresent())
        {
            accountRepo.deleteById(id);
            return new ResponseEntity<>(null,  HttpStatus.OK);
        }
        return new ResponseEntity<>(null,  HttpStatus.NOT_FOUND);
    }



}
