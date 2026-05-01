package com.library.users;

import com.library.users.entities.AppRole;
import com.library.users.entities.AppUser;
import com.library.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class UsersMicroserviceApplication {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UsersMicroserviceApplication.class, args);
    }

    @PostConstruct
    void initUsers() {
        // Ajouter les rôles
        userService.addRole(new AppRole(null, "ADMIN"));
        userService.addRole(new AppRole(null, "USER"));

        // Ajouter les utilisateurs
        userService.saveUser(new AppUser(null, "admin", "admin123", true, null));
        userService.saveUser(new AppUser(null, "user1", "user123", true, null));
        userService.saveUser(new AppUser(null, "user2", "user123", true, null));

        // Assigner les rôles
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("admin", "USER");
        userService.addRoleToUser("user1", "USER");
        userService.addRoleToUser("user2", "USER");
    }
}
