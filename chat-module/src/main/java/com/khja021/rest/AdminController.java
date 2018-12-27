package com.khja021.rest;

import com.khja021.dto.UserDto;
import com.khja021.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@RestController
@Secured("ROLE_ADMIN")
@RequestMapping("/clients")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserDto> getUsers(){return userService.getUsers();}

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void blockUser(@PathVariable("id") int userID){
        userService.blockUser(userID);
    }
}
