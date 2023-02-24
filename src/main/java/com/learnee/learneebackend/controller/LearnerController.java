package com.learnee.learneebackend.controller;


import com.learnee.learneebackend.exception.LearnerNotFoundException;
import com.learnee.learneebackend.model.Learner;
import com.learnee.learneebackend.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class LearnerController {
    @Autowired
    private LearnerRepository learnerRepository;

    @PostMapping("/addlearner")
    Learner newLearner(@RequestBody Learner newLearner) { return learnerRepository.save(newLearner);}

    @GetMapping("/getlearners")
    List<Learner> getAllLearners() { return learnerRepository.findAll();}

    @GetMapping("/getlearner/{id}")
    Learner getLearnerById(@PathVariable Long id) {
        return learnerRepository.findById(id)
                .orElseThrow(() -> new LearnerNotFoundException(id));
    }

    @PutMapping("/updatelearner/{id}")
    Learner updateLearner(@RequestBody Learner newLearner, @PathVariable Long id){
        return learnerRepository.findById(id)
                .map(learner -> {
                    learner.setFname(newLearner.getFname());
                    learner.setLname(newLearner.getLname());
                    learner.setPromotion(newLearner.getPromotion());
                    learner.setAddress(newLearner.getAddress());
                    learner.setEmail(newLearner.getEmail());
                    learner.setMobile(newLearner.getMobile());
                    learner.setAbsence(newLearner.getAbsence());
                    learner.setRepresentative(newLearner.getRepresentative());
                    return learnerRepository.save(learner);
                }).orElseThrow(() -> new LearnerNotFoundException(id));
    }

    @DeleteMapping("deletelearner/{id}")
    String deleteLearner(@PathVariable Long id){
        if(!learnerRepository.existsById(id)) {
            throw new LearnerNotFoundException(id);
        }
        learnerRepository.deleteById(id);
        return "L'apprenant avec l'id " + id + " a été correctement supprimé.";
    }
}
