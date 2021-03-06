package com.raloliver.authservice.service;

import java.util.List;

import javax.transaction.Transactional;

import com.raloliver.authservice.domain.Role;
import com.raloliver.authservice.domain.User;
import com.raloliver.authservice.repository.RoleRepository;
import com.raloliver.authservice.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @RequiredArgsConstructor: lombok will be create a constructor and pass inside
 *                           all props from this class.
 * @Slf4j for log proposals.
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("save user {}", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("save role {}", role.getName());
        return roleRepository.save(role);
    }

    /**
     * Because of the @Transactional, the role will be save on method execution.
     */
    @Override
    public void addUserRole(String username, String roleName) {
        log.info("add role {} to {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("get user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("get all users");
        return userRepository.findAll();
    }

}
