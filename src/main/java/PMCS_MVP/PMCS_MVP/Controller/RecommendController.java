package PMCS_MVP.PMCS_MVP.Controller;

import PMCS_MVP.PMCS_MVP.Model.Recommend;
import PMCS_MVP.PMCS_MVP.Repo.RecommendRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("Recommend")
public class RecommendController {

    RecommendRepo recommendRepo;

    RecommendController(RecommendRepo recommendRepo)
    {
        this.recommendRepo = recommendRepo;
    }

    @PostMapping("")
    ResponseEntity<Recommend> postRecommendation(@RequestBody Recommend body)
    {
        return new ResponseEntity<>(recommendRepo.save(body), HttpStatus.OK);
    }

    @GetMapping("")
    List<Recommend> getAllRecommend()
    {
        return recommendRepo.findAll();
    }

    @DeleteMapping("{id}")
    ResponseEntity<Recommend> deleteRecommend(@PathVariable Long id)
    {
        if (recommendRepo.findById(id).isPresent())
        {
            recommendRepo.deleteById(id);
           return new ResponseEntity<>(null, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}
