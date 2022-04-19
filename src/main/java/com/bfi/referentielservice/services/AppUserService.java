package com.bfi.referentielservice.services;

import com.bfi.referentielservice.entities.AppRole;
import com.bfi.referentielservice.entities.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    AppRole saveRole(AppRole role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String Username);
    List<AppUser> getUsers();

}
