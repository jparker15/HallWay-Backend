package com.careerdevs.myHalwayLocker.controllers;

import com.careerdevs.myHalwayLocker.models.Developer;
import com.careerdevs.myHalwayLocker.repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/devs")
public class DeveloperController {
        
        @Autowired
        private DeveloperRepository repository;

        @GetMapping
        public @ResponseBody
        List<Developer> getAllDevelopers() {
            return repository.findAll();
        }

//        @GetMapping("/cohort/{cohort}")
//        public ResponseEntity<List<Developer>> getByCohort(@PathVariable Integer cohort) {
//            return new ResponseEntity<>(repository.findDevelopersByCohort(cohort, Sort.by("firstName")), HttpStatus.OK);
//        }

        @GetMapping("/{id}")
        public @ResponseBody Developer findById(@PathVariable Long id) {
            return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        @PostMapping
        public ResponseEntity<Developer> createDeveloper(@RequestBody Developer newDeveloper) {
//        System.out.println(newDeveloper.getLocker().getId());
            return new ResponseEntity<>(repository.save(newDeveloper), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public @ResponseBody Developer updateDeveloper(@PathVariable Long id, @RequestBody Developer updatedData) {
            Developer Developer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            if (updatedData.getFirstName() != null) Developer.setFirstName(updatedData.getFirstName());
            if (updatedData.getLastName() != null) Developer.setLastName(updatedData.getLastName());

            return repository.save(Developer);

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> destroyDeveloper(@PathVariable Long id) {
            repository.deleteById(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        

}
