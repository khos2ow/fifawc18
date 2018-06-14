package io.khosrow.fifawc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.Prediction;
import io.khosrow.fifawc.domain.User;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
    List<Prediction> findByUser(User user);
}
