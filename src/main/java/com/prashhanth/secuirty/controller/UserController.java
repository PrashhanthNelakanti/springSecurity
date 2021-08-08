package com.prashhanth.secuirty.controller;

import com.prashhanth.secuirty.config.AppUserDetailsService;
import com.prashhanth.secuirty.config.JwtTokenUtil;
import com.prashhanth.secuirty.entity.CustomUser;
import com.prashhanth.secuirty.entity.JwtRequest;
import com.prashhanth.secuirty.entity.JwtResponse;
import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AppUserDetailsService userDetailsService;
    @PostMapping("/add")
    public User addDefaults(@RequestBody User user){
        logger.info("User added from Controller "+user);
        return service.addUser(user);
    }

    @GetMapping("/health")
    public String getStatus(){
        return "UP";
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id){
        logger.info("Id passed to Controller "+id);
        return service.getUserById(id);
    }

    @GetMapping("/user/name/{name}")
    public Optional<User> getUserByName(@PathVariable("name") String name){
        logger.info("Id passed to Controller "+name);
        return service.getUserByName(name);
    }

    @GetMapping("/admin")
    public List<User> getAllUsers(){
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

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/only/users")
    public List<CustomUser> allUsers(){
        return service.getUsers();
    }

}
