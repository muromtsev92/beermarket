package com.example.beermarket.services;

import com.example.beermarket.models.Role;
import com.example.beermarket.models.User;
import com.example.beermarket.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean createUser(User user){
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        user.setActive(true);
        user.getRoles().add(Role.USER);
        return true;
    }
}
