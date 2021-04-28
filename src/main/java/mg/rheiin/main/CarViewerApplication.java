package mg.rheiin.main;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import mg.rheiin.main.entities.User;
import mg.rheiin.main.repositories.UserRepository;

@SpringBootApplication
@ComponentScan
public class CarViewerApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(CarViewerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User("admin", passwordEncoder.encode("admin"));
		userRepository.save(user);
		
	}
}
