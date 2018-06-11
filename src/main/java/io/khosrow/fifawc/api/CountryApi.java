package io.khosrow.fifawc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.khosrow.fifawc.common.dto.CountryDTO;
import io.khosrow.fifawc.service.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryApi {
    private final CountryService service;

    @Autowired
    public CountryApi(CountryService service) {
        this.service = service;
    }

    @GetMapping(params = {"sort"})
    public List<CountryDTO> getAllCountries(@RequestParam(name = "sort", required = false) String sort) {
        return service.getAllCountries(sort);
    }

    @GetMapping(params = {"name"})
    public CountryDTO getCountryByName(@RequestParam(name = "name", required = true) String name) {
        return service.getCountryByName(name);
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryByUuid(@PathVariable(value = "id") String uuid) {
        return service.getCountryByUuid(uuid);
    }
}
