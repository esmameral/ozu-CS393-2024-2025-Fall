package ozyegin.myproject.beans;

import org.springframework.stereotype.Component;

@Component("enMessage")
public class MessageBeanEnImpl implements MessageBean {

	@Override
	public String getMessage() {
		return "Hello, how are you?";
	}

}
