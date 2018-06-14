package io.khosrow.fifawc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByPrincipalId(String principalId);
}
