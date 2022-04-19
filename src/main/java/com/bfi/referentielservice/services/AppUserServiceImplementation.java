package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.AppRole;
import com.bfi.referentielservice.entities.AppUser;
import com.bfi.referentielservice.repositories.AppRoleRepository;
import com.bfi.referentielservice.repositories.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class AppUserServiceImplementation implements AppUserService, UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user =appUserRepository.findByUsername(username);
        if (user == null) {
            log.error("user not found in the database");
            throw new UsernameNotFoundException("user not found in the database");
        } else {
            log.info("saving new user {} to the database", user.getName());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);

    }

    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = appUserRepository.findByUsername(username);
        AppRole role = appRoleRepository.findByName(roleName);
        user.getRoles().add(role);


    }

    @Override
    public AppUser getUser(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {

        return appUserRepository.findAll();
    }


}
