package com.cognizant;

import java.util.Optional;

public interface UserRepositorySpring {

    Optional<UserEntity> findById(Long id);
}