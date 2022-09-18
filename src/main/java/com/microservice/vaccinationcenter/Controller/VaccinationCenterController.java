package com.microservice.vaccinationcenter.Controller;

import com.microservice.vaccinationcenter.Entity.VaccinationCenter;
import com.microservice.vaccinationcenter.Model.Citizen;
import com.microservice.vaccinationcenter.Model.Response;
import com.microservice.vaccinationcenter.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/VaccinationCenter")
public class VaccinationCenterController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;

    @RequestMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hello Megha", HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vaccinationCenter) {
        VaccinationCenter vaccinationCenterDetails = vaccinationCenterRepository.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenterDetails, HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Response> getAllDatailsOfCenterId(@PathVariable Integer id) {
        Response response = new Response();
        VaccinationCenter vaccinationCenterDetails = vaccinationCenterRepository.findById(id).get();
        response.setVaccinationCenter(vaccinationCenterDetails);
        List<Citizen> listOfCitizen = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
        response.setCitizens(listOfCitizen);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }
}
