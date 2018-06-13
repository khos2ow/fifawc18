package io.khosrow.fifawc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    Optional<Match> findByUuid(String uuid);

    List<Match> findByGroupId(Integer groupId);

    List<Match> findByStage(Stage stage);
}
