package io.khosrow.fifawc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByUuid(String uuid);

    Optional<Group> findByName(String name);
}
