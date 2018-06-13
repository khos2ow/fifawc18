package io.khosrow.fifawc.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.common.util.Stage;
import io.khosrow.fifawc.domain.Match;
import io.khosrow.fifawc.domain.Team;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {
    Optional<Match> findByUuid(String uuid);

    Optional<Match> findByNumber(String number);

    List<Match> findByGroupId(Integer groupId);

    List<Match> findByStage(Stage stage);

    Optional<Match> findByTeam1AndTeam2(Team team, Team team2);

    Optional<Match> findByTeam1Indicator(String indicator);

    Optional<Match> findByTeam2Indicator(String indicator);
}
