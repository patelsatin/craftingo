package com.caftingo.controller;

import com.caftingo.models.AuthRequest;
import com.caftingo.models.User;
import com.caftingo.service.JwtService;
import com.caftingo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/craftingo")
public class UserController {

    @Autowired
    private UserService uService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/register")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        User user1 = uService.findByEmail(user.getEmail());
        if(user1 != null){ return new ResponseEntity<String>("Email is already Present" , HttpStatus.BAD_REQUEST); }
        uService.saveUser(user);
        return new ResponseEntity<String>(jwtService.generateToken(user.getEmail()), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return uService.getAll();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        try {
            Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
            if (auth.isAuthenticated()) {
                return new ResponseEntity<String>(jwtService.generateToken(authRequest.getUserName()), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<String>("invalid User",HttpStatus.UNAUTHORIZED);
            }
        }
        catch (Exception e) {
            return new ResponseEntity<String>("invalid User",HttpStatus.UNAUTHORIZED);
        }
    }

}
