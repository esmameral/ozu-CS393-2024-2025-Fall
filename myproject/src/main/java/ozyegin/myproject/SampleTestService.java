package ozyegin.myproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleTestService {
	
	@Value("${myapp.hellomessage}")
	private String message;
	
	@RequestMapping("/sayhello")
	public String sayHello() {
		return "Hello Spring World! " + message;
	}
	
	@RequestMapping("/sysdate")
	public String getDate() {
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return df.format(date);
	}

}
