package mg.rheiin.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CarViewerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarViewerApplication.class, args);
	}

}
