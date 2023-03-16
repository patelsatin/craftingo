package com.caftingo.service;

import com.caftingo.models.User;
import com.caftingo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public void saveUser(User user){
       repo.save(user);
    }

    public List<User> getAll(){
        return repo.findAll();
    }

    public User findByEmail(String email) {return  repo.findByEmail(email);}
}
