package PMCS_MVP.PMCS_MVP.Controller;


import PMCS_MVP.PMCS_MVP.Model.PMCS;
import PMCS_MVP.PMCS_MVP.Repo.PMCSRepo;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

    //GET ONE
    @GetMapping("{id}")
    ResponseEntity<PMCS> getOnePMCS(@PathVariable Long id)
    {
        if (pmcsRepo.findById(id).isPresent())
        {
            return new ResponseEntity<>(pmcsRepo.findById(id).get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/byEquipmentName/{name}")
    List<PMCS> byEquipmentName(@PathVariable String name)
    {
        return pmcsRepo.findByItemNameContaining(name);
    }

    //UPDATE
    @PatchMapping("{id}")
    ResponseEntity<PMCS> patchOnePMCS(@PathVariable Long id, @RequestBody Map<String, String> body)
    {
        if(pmcsRepo.findById(id).isPresent())
        {
            PMCS holder = pmcsRepo.findById(id).get();
            for (Map.Entry<String, String> entry: body.entrySet())
            {
                switch (entry.getKey())
                {
                    case  "itemName" -> holder.setItemName(entry.getValue());
                    case  "publishDate" -> holder.setPublishDate(LocalDate.parse(entry.getValue()));
                    case  "tmNumber" -> holder.setTmNumber(entry.getValue());
                    case  "pageCount" -> holder.setPageCount(Integer.valueOf(entry.getValue()));
                    case  "pagePmcsStart" -> holder.setPagePmcsStart(Integer.valueOf(entry.getValue()));
                }
            }
            return new ResponseEntity<>(pmcsRepo.save(holder), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }




}
