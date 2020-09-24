package org.sid;

import java.util.stream.Stream;

import org.sid.dao.AppRoleRepository;
import org.sid.entity.AppRole;
import org.sid.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SpringSecurityJwt1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwt1Application.class, args);
	}

	 @Bean
	    CommandLineRunner start(AccountService accountService , AppRoleRepository roleRepo){
	        return args->{
	        	AppRole r1 =roleRepo.save(new AppRole( null ,"LOCATAIRE"));
	            accountService.save(new AppRole(null,"USER"));
	            accountService.save(new AppRole(null,"ADMIN"));	//,"admin@korbi.net"
	            Stream.of("omar@korbi.net","user1","user2","user3").forEach(un->{
	                accountService.saveUser(un,"1234","1234","2121212" ,"Male" ,"monjislim", "125255","omar","omar");
	            });
	            accountService.saveAdmin("admin@korbi.net", "1234", "1234", "omar", "omar");
	            accountService.addRoleToUser("admin@korbi.net","ADMIN");
	        };
	    } 
	    
	    @Bean
	    BCryptPasswordEncoder getBCPE(){
	        return new BCryptPasswordEncoder();
	    }

}
