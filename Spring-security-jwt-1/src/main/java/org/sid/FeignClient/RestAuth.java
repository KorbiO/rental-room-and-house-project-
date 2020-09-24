package org.sid.FeignClient;

import org.sid.common.UserForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CrudApplication")
public interface RestAuth {

	@PostMapping("/client")
	public UserForm postClientDetails(@RequestBody UserForm userForm);
	
	@PutMapping("/client/{username}")
	public UserForm putClientDetails(@RequestBody UserForm userForm , @PathVariable("username") String username);
	
	//Locataire
	
	@PostMapping("/locataire")
	public UserForm postLocataireDetails(@RequestBody UserForm userForm);
	
	@PutMapping("/locataire/{username}")
	public UserForm putLocataireDetails(@RequestBody UserForm userForm , @PathVariable("username") String username);

	@PutMapping("/admin/{username}")
	public UserForm putAdminDetails(@RequestBody UserForm userForm , @PathVariable("username") String username);

}
