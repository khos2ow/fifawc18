package io.khosrow.fifawc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.khosrow.fifawc.common.dto.UserDTO;
import io.khosrow.fifawc.repo.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * @return
     */
    public List<UserDTO> getLeaderboard() {
        return repository.findAll()
                .stream()
                .sorted((u1, u2) -> u2.getPoints().compareTo(u1.getPoints()))
                .map(UserDTO::of)
                .collect(Collectors.toList());
    }
}
