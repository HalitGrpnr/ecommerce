package com.ecommerce.application.service;

import com.ecommerce.application.domain.entity.ConfirmationToken;
import com.ecommerce.application.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    @Autowired
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }

    public void deleteConfirmationToken(Long id){
        confirmationTokenRepository.deleteById(id);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token){
        return  confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
    }

}
