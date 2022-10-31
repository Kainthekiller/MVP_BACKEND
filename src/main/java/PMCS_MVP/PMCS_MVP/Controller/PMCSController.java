package PMCS_MVP.PMCS_MVP.Controller;


import PMCS_MVP.PMCS_MVP.Model.PMCS;
import PMCS_MVP.PMCS_MVP.Repo.PMCSRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/PMCS")
public class PMCSController {

    PMCSRepo pmcsRepo;

    PMCSController(PMCSRepo pmcsRepo)
    {
        this.pmcsRepo = pmcsRepo;
    }



    //POST
    @PostMapping("")
    ResponseEntity<PMCS> postPMCS(@RequestBody PMCS body)
    {
        return new ResponseEntity<>(pmcsRepo.save(body), HttpStatus.OK);
    }

    //GET ALL
    @GetMapping("")
    List<PMCS> getAllPMCS()
    {
        return pmcsRepo.findAll();
    }


}
