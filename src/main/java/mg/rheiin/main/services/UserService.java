package mg.rheiin.main.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mg.rheiin.main.entities.User;
import mg.rheiin.main.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUsername(username);
		if (Objects.isNull(user)) {
			throw new UsernameNotFoundException("Username not found");
		} else {
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), new ArrayList<SimpleGrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		}
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
