package io.khosrow.fifawc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Prediction;
import io.khosrow.fifawc.domain.Team;
import io.khosrow.fifawc.domain.User;

@Repository
public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
    List<Prediction> findByUser(User user);

    List<Prediction> findByGroupIdAndUserId(Integer groupId, Integer userId);

    List<Prediction> findByStageAndUserId(Stage stage, Integer userId);

    Optional<Prediction> findByNumberAndUserId(String number, Integer userId);

    Optional<Prediction> findByTeam1AndTeam2AndUserId(Team team, Team team2, Integer userId);

    Optional<Prediction> findByTeam1IndicatorAndUserId(String indicator, Integer userId);

    Optional<Prediction> findByTeam2IndicatorAndUserId(String indicator, Integer userId);
}
