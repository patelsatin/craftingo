package com.caftingo.service;

import com.caftingo.models.User;
import com.caftingo.models.UserInfoToUserDetails;
import com.caftingo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
;

@Component
public class UserDetailsInfo implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userRepo.findByEmail(username);
       if(user != null){
           return new UserInfoToUserDetails(user);
       }
       else{
           throw new UsernameNotFoundException("User not found");
       }

    }


}
