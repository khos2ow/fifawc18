package io.khosrow.fifawc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;

import io.khosrow.fifawc.common.dto.CountryDTO;
import io.khosrow.fifawc.repo.CountryRepository;

@Service
public class CountryService {
    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    /**
     * Find a Country by its UUID
     * 
     * @param uuid to look for
     * 
     * @return CountryDTO instance
     */
    public CountryDTO getCountryByUuid(String uuid) {
        return CountryDTO.of(repository.findByUuid(uuid));
    }

    /**
     * Find a Country by its name
     * 
     * @param name to look for
     * 
     * @return CountryDTO instance
     */
    public CountryDTO getCountryByName(String name) {
        return CountryDTO.of(repository.findByName(name));
    }

    /**
     * Find all countries
     * 
     * @param sort 
     * 
     * @return list of CountryDTO
     */
    public List<CountryDTO> getAllCountries(final String sort) {
        final Sort sortBy = !Strings.isNullOrEmpty(sort) ? Sort.by(Sort.Order.asc(sort)) : Sort.unsorted();

        return repository.findAll(sortBy)
                .stream()
                .map(CountryDTO::of)
                .collect(Collectors.toList());
    }
}
