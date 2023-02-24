package com.learnee.learneebackend.repository;

import com.learnee.learneebackend.model.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {
}
