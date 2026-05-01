package com.library.users.restcontrollers;

import com.library.users.entities.AppUser;
import com.library.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<AppUser> getAllUsers() {
        return userService.findAllUsers();
    }
}
