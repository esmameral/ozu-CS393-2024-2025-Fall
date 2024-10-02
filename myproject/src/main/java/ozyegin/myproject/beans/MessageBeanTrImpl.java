package ozyegin.myproject.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("trMessage")
@Primary
public class MessageBeanTrImpl implements MessageBean {

	@Override
	public String getMessage() {
		
		
		return "Merhaba, nasılsınız?";
	}

}
