package org.example.Service;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;
    private TokenService tokenService;

    public UserService(UserRepository userRepo,TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService=tokenService;
    }

    public User saveuser(User obj) {
        User userfinal = userRepo.save(obj);
        return userfinal;
    }

    public String userLogin(String email, String password) {
        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword1().equals(password)) {
                // Successful login
                String token = tokenService.createTokenFunction(user.getId());
                return "Successfully logged in. Token: " + token;
            } else {
                return "Authentication failed: Incorrect password";
            }
        } else {
            return "Authentication failed: User not found";
        }
    }








}

