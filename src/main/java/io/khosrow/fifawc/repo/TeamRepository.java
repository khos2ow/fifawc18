package io.khosrow.fifawc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findByUuid(String uuid);
}
