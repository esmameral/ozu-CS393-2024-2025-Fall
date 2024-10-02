package ozyegin.myproject;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ozyegin.myproject")
public class AppConfig {
	
	@Bean("dateFormat")
	public SimpleDateFormat  getDateFormat() {
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	}

}
