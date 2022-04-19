package com.bfi.referentielservice.controller;

import com.bfi.referentielservice.entities.AppRole;
import com.bfi.referentielservice.entities.AppUser;
import com.bfi.referentielservice.services.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserResource {
    private final AppUserService appUserService;

    @GetMapping("/users")
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(appUserService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
        return ResponseEntity.ok().body(appUserService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<AppRole>saveRole(@RequestBody AppRole role){
        return ResponseEntity.ok().body(appUserService.saveRole(role));
    }
    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        appUserService.addRoleToUser(form.getUserName(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

}

@Data
class RoleToUserForm{
    private String userName;
    private String roleName;
}
