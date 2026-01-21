package com.apnabazar.app.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnabazar.app.entity.UserEntity;
import com.apnabazar.app.repository.UserRepository;
import com.apnabazar.app.request.UserRequest;

@Service
public class UserService {

	@Autowired
    private UserRepository repo ;

    public String createUser(UserRequest r) {
        String password = UUID.randomUUID().toString().substring(0, 8);

        UserEntity u = new UserEntity();
        u.setUsername(r.username);
        u.setEmail(r.email);
        u.setPassword(password);

        repo.save(u);
        return password;
    }

   
    public boolean login(String username, String password) {
        return repo.find(username, password) != null;
    }
}
