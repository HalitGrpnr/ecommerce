package com.ecommerce.application.repository;

import com.ecommerce.application.domain.entity.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> findConfirmationTokenByConfirmationToken(String token);
}
