package com.microservice.ctitzenservice.Controller;

import com.microservice.ctitzenservice.Entity.Citizen;
import com.microservice.ctitzenservice.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

    @Autowired
    private  CitizenRepository citizenRepository;


    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello Megha", HttpStatus.OK);
    }

    @RequestMapping(path = "/id/{id}")
    public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
        List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(id);
        return new ResponseEntity<>(citizenList, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        Citizen citizenDetails = citizenRepository.save(citizen);
        return new ResponseEntity<>(citizenDetails, HttpStatus.OK);
    }
}
