package io.khosrow.fifawc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.khosrow.fifawc.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Optional<Country> findByUuid(String uuid);

    Optional<Country> findByName(String name);
}
