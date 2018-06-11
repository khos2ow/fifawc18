package io.khosrow.fifawc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.Standing;

@Repository
public interface StandingRepository extends JpaRepository<Standing, Integer> {
    List<Standing> findByGroupId(Integer groupId);
}
