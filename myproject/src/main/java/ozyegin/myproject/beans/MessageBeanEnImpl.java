package ozyegin.myproject.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("message")
@Profile("en")
public class MessageBeanEnImpl implements MessageBean {
	
	@Value("${hello.message}")
	private String message;

	@Override
	public String getMessage() {
		return message;
	}

}
