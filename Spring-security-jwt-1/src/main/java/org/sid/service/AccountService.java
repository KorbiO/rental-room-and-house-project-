package org.sid.service;

import org.sid.entity.AppRole;
import org.sid.entity.AppUser;

public interface AccountService {
    public AppUser saveUser(String username,String password,String confirmedPassword,String phoneNumber , String gender, String address , String cin , String nom , String prenom);
    public AppUser saveAdmin(String username, String password, String confirmedPassword, String nom , String prenom);
    public AppUser saveLocataire(String username,String password,String confirmedPassword,String phoneNumber , String gender, String address, String cin , String nom , String prenom);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}
