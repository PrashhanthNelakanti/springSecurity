package com.prashhanth.secuirty.controller;

import com.prashhanth.secuirty.config.AppUserDetailsService;
import com.prashhanth.secuirty.config.JwtTokenUtil;
import com.prashhanth.secuirty.entity.JwtRequest;
import com.prashhanth.secuirty.entity.JwtResponse;
import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.service.UserService;
import com.prashhanth.secuirty.service.transactions.UserTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @Autowired
    UserTransactionService userTransactionService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AppUserDetailsService userDetailsService;
    @PostMapping("/add")
    public ResponseEntity<?> addDefaults(@RequestBody User user){
        logger.info("User added from Controller "+user);
        return service.addUser(user);
    }

    @GetMapping("/health")
    public String getStatus(){
        return "UP";
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id){
        logger.info("Id passed to Controller "+id);
        Optional<User> user=service.getUserById(id);
        return new ResponseEntity(user.get(), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers(){
        logger.info("Find All Users");
        return service.getAllUsers();
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/accounts")
    public String transaction(@RequestBody User user){
        logger.info("Making a tranction");
        return userTransactionService.transactions(user);
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
