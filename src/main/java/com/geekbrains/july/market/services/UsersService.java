package com.geekbrains.july.market.services;

import com.geekbrains.july.market.entities.Role;
import com.geekbrains.july.market.entities.User;
import com.geekbrains.july.market.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UserDetailsService {
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User findByUsername(String username) {
        return usersRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
    }
    public User findById(Long id) {
       return usersRepository.findById(id).orElseThrow(
                                () -> new UsernameNotFoundException(String.format("Can't found user with %d", id)));
    }
    public User saveOrUpdate(User user) {
        return usersRepository.save(user);
    }
    public List<User> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                      user.getPassword(),
                                                                      true,
                                                                      true,
                                                                      true,
                                                                      !user.isLocked(),
                                                                      mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}