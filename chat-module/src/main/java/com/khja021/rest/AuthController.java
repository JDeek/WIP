package com.khja021.rest;

import com.khja021.dto.UserDto;
import com.khja021.service.UserDetailsServiceImpl;
import com.khja021.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestParam("j_username") String username,
                                   @RequestParam("j_password") String password){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        token.setDetails(userDetails);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new ResponseEntity<Object>(userService.getUser(auth.getName()), HttpStatus.OK);
        }catch (BadCredentialsException e){
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<?> logout(){
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto){
        if (userService.getUser(userDto.getLogin()) == null){
            userService.addUser(userDto);
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(userDto.getLogin(),userDto.getPassword());
            UserDetails userDetails = userDetailsService.loadUserByUsername(userDto.getLogin());
            token.setDetails(userDetails);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<Object>(userService.getUser(authentication.getName()),HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.GET)
    public boolean isLoginUnique(String login){
        return null == userService.getUser(login);
    }
}
