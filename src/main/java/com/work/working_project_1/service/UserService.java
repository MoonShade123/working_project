package com.work.working_project_1.service;

import com.work.working_project_1.commons.UserRole;
import com.work.working_project_1.dto.UserDto;
import com.work.working_project_1.dto.dtoConverter.ToDtoConverter;
import com.work.working_project_1.exceptions.UserException;
import com.work.working_project_1.model.Role;
import com.work.working_project_1.model.User;
import com.work.working_project_1.repository.RoleRepository;
import com.work.working_project_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(final UserRepository userRepository, final RoleRepository roleRepository, final BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void signUp(final User user) throws UserException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByUserRole(UserRole.USER);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);
        this.userRepository.save(user);
    }

    @PreAuthorize("hasRole('USER')")
    public Collection<UserDto> getAll() {
        Collection<User> users = this.userRepository.findAll();
        return users.stream()
                .map(ToDtoConverter::userToDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('USER')")
    public UserDto getById(final Long id) {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new UserException("Can't get. User not found!")
        );
        return ToDtoConverter.userToDto(user);
    }

    public User getByPhoneNumber(final String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @PreAuthorize("hasRole('USER')")
    public UserDto update(final User user) {
        this.userRepository.findById(user.getId()).orElseThrow(
                () -> new UserException("Can't update. User not found!")
        );
        this.userRepository.save(user);
        return ToDtoConverter.userToDto(user);
    }


    public User findOne(final String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(final User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getUserRole()));
        });
        return authorities;
    }

}
