package org.sid.web;

import org.sid.FeignClient.RestAuth;
import org.sid.common.UserForm;
import org.sid.dao.AppUserRepository;
import org.sid.entity.AppUser;

import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private RestAuth restAuth;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUserRepository appUserRepo ;
    
  
    @PostMapping("/registerUser")
    public AppUser registerUser(@RequestBody  UserForm userForm){
    	restAuth.postClientDetails(userForm);
        return  accountService.saveUser(userForm.getUsername() , userForm.getPassword(),userForm.getConfirmedPassword()
        		    ,userForm.getPhoneNumber() ,userForm.getGender(),userForm.getAddress(), userForm.getCin(),userForm.getNom(),userForm.getPrenom());
    }
    @PostMapping("/registerLocataire")
    public AppUser registerLocataire(@RequestBody  UserForm userForm){
    	restAuth.postLocataireDetails(userForm);
        return  accountService.saveLocataire(userForm.getUsername() ,userForm.getPassword(),userForm.getConfirmedPassword()
        		    ,userForm.getPhoneNumber() ,userForm.getGender(),userForm.getAddress(), userForm.getCin(),userForm.getNom(),userForm.getPrenom());
    }
    @PutMapping("/putClient/{username}")
    public AppUser putUser(@RequestBody  UserForm userForm , @PathVariable("username") String username) {
    	AppUser appuser = accountService.loadUserByUsername(username);
    	appuser.setMat(username);
    	appuser.setAddress(userForm.getAddress());
    	appuser.setCin(userForm.getCin());
    	appuser.setConfirmedPassword(bCryptPasswordEncoder.encode(userForm.getConfirmedPassword()));
    	appuser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
    	appuser.setPhoneNumber(userForm.getPhoneNumber());
    	appuser.setNom(userForm.getNom());
    	appuser.setPrenom(userForm.getPrenom());
    	appuser.setGender(userForm.getGender());
    	appuser =appUserRepo.save(appuser);
    	restAuth.putClientDetails(userForm,username);
		return appuser;
    }
    @PutMapping("/putLocataire/{username}")
    public AppUser putFour(@RequestBody  UserForm userForm , @PathVariable("username") String username) {
    	AppUser appuser = accountService.loadUserByUsername(username);
    	
    	appuser.setAddress(userForm.getAddress());
    	appuser.setCin(userForm.getCin());
    	appuser.setNom(userForm.getNom());
    	appuser.setPrenom(userForm.getPrenom());
    	appuser.setGender(userForm.getGender());
    	appuser.setConfirmedPassword(bCryptPasswordEncoder.encode(userForm.getConfirmedPassword()));
    	appuser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
    	appuser.setPhoneNumber(userForm.getPhoneNumber());
    	appuser =appUserRepo.save(appuser);
    	restAuth.putLocataireDetails(userForm, username);
		return appuser;
    }
    
    @PutMapping("/putAdmin/{username}")
    public AppUser putAdmin(@RequestBody  UserForm userForm , @PathVariable("username") String username) {
    	AppUser appuser = accountService.loadUserByUsername(username);
    	
    	appuser.setAddress(userForm.getAddress());
    	appuser.setCin(userForm.getCin());
    	appuser.setNom(userForm.getNom());
    	appuser.setPrenom(userForm.getPrenom());
    	appuser.setConfirmedPassword(bCryptPasswordEncoder.encode(userForm.getConfirmedPassword()));
    	appuser.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
    	appuser.setPhoneNumber(userForm.getPhoneNumber());
    	appuser.setGender(userForm.getGender());
    	appuser =appUserRepo.save(appuser);
    	restAuth.putAdminDetails(userForm, username);
		return appuser;
    }
    
    @GetMapping("/appUsers/{username}")
    public AppUser getUserByusername(@PathVariable("username") String username) {
    	AppUser a = appUserRepo.findByUsername(username);
    	System.out.println(a.getPassword());
    	return a;
    }
    
}


