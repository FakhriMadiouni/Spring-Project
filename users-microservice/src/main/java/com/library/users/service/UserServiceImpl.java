package com.library.users.service;

import com.library.users.entities.AppRole;
import com.library.users.entities.AppUser;
import com.library.users.repos.AppRoleRepository;
import com.library.users.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    AppUserRepository userRepository;

    @Autowired
    AppRoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppRole addRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public AppUser addRoleToUser(String username, String rolename) {
        AppUser user = userRepository.findByUsername(username);
        AppRole role = roleRepository.findByRole(rolename);
        user.getRoles().add(role);
        return user;
    }

    @Override
    public List<AppUser> findAllUsers() {
        return userRepository.findAll();
    }
}
