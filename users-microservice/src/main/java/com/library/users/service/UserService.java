package com.library.users.service;

import com.library.users.entities.AppRole;
import com.library.users.entities.AppUser;
import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    AppUser findUserByUsername(String username);
    AppRole addRole(AppRole role);
    AppUser addRoleToUser(String username, String rolename);
    List<AppUser> findAllUsers();
}
