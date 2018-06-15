package io.khosrow.fifawc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.PredictionStanding;
import io.khosrow.fifawc.domain.User;

@Repository
public interface PredictionStandingRepository extends JpaRepository<PredictionStanding, Integer> {
    List<PredictionStanding> findByUser(User user);

    List<PredictionStanding> findByGroupIdAndUserId(Integer groupId, Integer userId);

    Optional<PredictionStanding> findByTeamIdAndUserId(Integer teamId, int userId);
}
