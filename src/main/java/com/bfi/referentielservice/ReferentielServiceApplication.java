package com.bfi.referentielservice;
import com.bfi.referentielservice.entities.*;
import com.bfi.referentielservice.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Date;


@SpringBootApplication
//@EntityScan("com.bfi.entities")
//@ComponentScan({"com.bfi.services"})
//@EnableJpaRepositories("com.bfi.repositories")
//@ComponentScan({"com.bfi.security"})

public class ReferentielServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferentielServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner start(PersonnePhysiqueRepository personnePhysiqueRepository, TiersRepository tiersRepository,
							PersonneMoraleRepository personneMoraleRepository, BanqueRepository banqueRepository,
							CompteRepository compteRepository) {
		return args -> {




			//PersonnePhysique pp1 = personnePhysiqueRepository.save(new PersonnePhysique(26,"célibataire","ali","raoudha", "Tunisie","tunisie","tunis",29677860L));
			//PersonnePhysique pp2 = personnePhysiqueRepository.save(new PersonnePhysique(30,"Mriié","samir","raoudha", "Congo","tunisie","tunis",29677860L));
			//PersonnePhysique pp3 = personnePhysiqueRepository.save(new PersonnePhysique(18,"Celibataire","sami","monjia", "Tunisie","tunisie","tunis",29677860L));
			//PersonnePhysique pp4 = personnePhysiqueRepository.save(new PersonnePhysique(28,"célibataire","dali","olfa", "Tunisie","tunisie","tunis",29677860L));
			//PersonnePhysique pp5 = personnePhysiqueRepository.save(new PersonnePhysique(42,"Marié","mohamed","sarra", "Italie","tunisie","tunis",29677860L));
			//PersonnePhysique pp6 = personnePhysiqueRepository.save(new PersonnePhysique(42,"Marié","mohamed","sarra", "Italie","tunisie","tunis",29677860L));

			//PersonnePhysique pp7 = personnePhysiqueRepository.save(new PersonnePhysique(42,"Marié","mohamed","sarra", "Italie","tunisie","tunis",29677860L));



			/*appUserService.saveUser(new AppUser(null,"souhail","souhail001","1234",new Date(),new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"mohammed","med007","1234",new Date(),new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"amine","amuneTwil02","1234",new Date(),new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"khaled","groomftw","1234",new Date(),new ArrayList<>()));

			appUserService.saveRole(new AppRole(null,"ROLE_USER",new Date()));
			appUserService.saveRole(new AppRole(null,"ROLE_ADMIN",new Date()));
			appUserService.saveRole(new AppRole(null,"ROLE_MANAGER",new Date()));
			appUserService.saveRole(new AppRole(null,"ROLE_SUPER_ADMIN",new Date()));

			appUserService.addRoleToUser("souhail001",	"ROLE_ADMIN");
			appUserService.addRoleToUser("amuneTwil02","ROLE_USER");
			appUserService.addRoleToUser("groomftw","ROLE_MANAGER");
			appUserService.addRoleToUser("med007","ROLE_USER");
			appUserService.addRoleToUser("med007","ROLE_ADMIN");
			appUserService.addRoleToUser("med007","ROLE_MANAGER");*/

		};
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings (CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:4200");
			}

		};
	}*/
}
