package com.bfi.referentielservice;
import com.bfi.referentielservice.entities.*;
import com.bfi.referentielservice.repositories.*;
import com.bfi.referentielservice.services.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootApplication
//@EnableGlobalMethodSecurity(prePostEnabled = true , securedEnabled = true)

public class ReferentielServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferentielServiceApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();

	}
	/*@Bean
	public CorsFilter corsFilter(){
		CorsConfiguration corsConfiguration =new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-type",
				"Accept","Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-type", "Accept","Authorization",
				"Access-Control-Allow-Origin","Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);


	}*/

	@Bean
	CommandLineRunner start(PersonnePhysiqueRepository personnePhysiqueRepository, TiersRepository tiersRepository,
							PersonneMoraleRepository personneMoraleRepository, BanqueRepository banqueRepository,
							CompteRepository compteRepository, AppUserService appUserService) {
		return args -> {

			Compte c1 = compteRepository.save(new Compte(null,"NUM_1123115","Compte epargne","1511321131615610",20000L,12000L,null,null,null,null));
			Compte c2 = compteRepository.save(new Compte(null,"NUM_2111899","Compte epargne","1511321131615610",100000L,8800L,null,null,null,null));
			Compte c3 = compteRepository.save(new Compte(null,"NUM_5615161","Compte cheque","1511321131615610",2000L,-2500L,null,null,null,null));


			PersonnePhysique pp1 = personnePhysiqueRepository.save(new PersonnePhysique(25,"celibataire","samir","raoudha","jerba"));
			PersonnePhysique pp2 = personnePhysiqueRepository.save(new PersonnePhysique(20,"celibataire","mohammed","ameni","kelibia"));
			//PersonnePhysique pp3 =personnePhysiqueRepository.save(new PersonnePhysique(null,))
			//Tiers pp3 = tiersRepository.save(new PersonnePhysique())

			appUserService.saveUser(new AppUser(null,"souhail","souhail001","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"mohammed","med007","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"amine","amuneTwil02","1234",new ArrayList<>()));
			appUserService.saveUser(new AppUser(null,"khaled","groomftw","1234",new ArrayList<>()));

			appUserService.saveRole(new AppRole(null,"ROLE_USER"));
			appUserService.saveRole(new AppRole(null,"ROLE_ADMIN"));
			appUserService.saveRole(new AppRole(null,"ROLE_MANAGER"));
			appUserService.saveRole(new AppRole(null,"ROLE_SUPER_ADMIN"));

			appUserService.addRoleToUser("souhail001",	"ROLE_ADMIN");
			appUserService.addRoleToUser("amuneTwil02","ROLE_USER");
			appUserService.addRoleToUser("groomftw","ROLE_MANAGER");
			appUserService.addRoleToUser("med007","ROLE_USER");
			appUserService.addRoleToUser("med007","ROLE_ADMIN");
			appUserService.addRoleToUser("med007","ROLE_MANAGER");









		};
	}
}
