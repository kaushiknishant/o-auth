package com.github.kaushiknishant.userservice.service;

import com.github.kaushiknishant.userservice.domain.Role;
import com.github.kaushiknishant.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
