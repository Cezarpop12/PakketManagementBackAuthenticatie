package com.Authenticatie.controller;

import com.Authenticatie.model.Postzegel;
import com.Authenticatie.service.PostzegelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postzegel")
@CrossOrigin
public class PostzegelController {

    @Autowired
    private PostzegelService postzegelService;

    @PostMapping("/add")
    public void add(@RequestBody Postzegel postzegel) {
            postzegelService.postzegelOpslaan(postzegel);
    }

    @GetMapping("/getAll")
    public List<Postzegel> getAllePostzegels(){
        return postzegelService.getAllePostzegels();
    }

    @GetMapping("/getById/{id}")
    public Postzegel findPostzegelById(int id) {
        return postzegelService.getPostzegelById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Postzegel> Delete(@PathVariable int id){
        Postzegel postzegel = postzegelService.getPostzegelById(id);
        if(postzegel != null){
            postzegelService.verwijderPostzegel(postzegel);
            return new ResponseEntity("Succesvol verwijderd", HttpStatus.OK);
        }
        return new ResponseEntity("Verwijderen mislukt", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Postzegel> Update(@RequestBody Postzegel postzegel, @PathVariable int id){
        Postzegel bestaandPostzegel = postzegelService.getPostzegelById(id);
        if(bestaandPostzegel !=null){
            bestaandPostzegel.setPrijs(postzegel.getPrijs());
            postzegelService.postzegelOpslaan(bestaandPostzegel);
            return new ResponseEntity("Postzegel succesvol geupdatet", HttpStatus.OK);
        }
        return new ResponseEntity("Updaten mislukt", HttpStatus.BAD_REQUEST);
    }
}
