package com.ecommerce.application.service.implementations;

import com.ecommerce.application.domain.entity.ConfirmationToken;
import com.ecommerce.application.domain.entity.User;
import com.ecommerce.application.repository.UserRepository;
import com.ecommerce.application.service.ConfirmationTokenService;
import com.ecommerce.application.service.EmailSenderService;
import com.ecommerce.application.service.interfaces.CustomerService;
import com.ecommerce.application.service.interfaces.SellerService;
import com.ecommerce.application.service.interfaces.StoreService;
import com.ecommerce.application.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StoreService storeService;

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public User add(User user) {
        Assert.notNull(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }

    public void signUpUser(User user) {
        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);



        //final ConfirmationToken confirmationToken = new ConfirmationToken(user);

        //confirmationTokenService.saveConfirmationToken(confirmationToken);

       // sendConfirmationMail(user.getEmail(), confirmationToken.getConfirmationToken());
    }

    public void sendConfirmationMail(String email, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Mail Confirmation");
        mailMessage.setText("Thank you for registered. Please confirm your account: "
                + "http://localhost:8080/sign-up/confirm?token=" + token);

        emailSenderService.sendEmail(mailMessage);
    }

    public void confirmUser(ConfirmationToken confirmationToken){
        final User user = confirmationToken.getUser();

        user.setEnabled(true);

        userRepository.save(user);

        confirmationTokenService.deleteConfirmationToken(confirmationToken.getId());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException("User not found: " + email);
        }
    }
}
