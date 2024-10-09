package ozyegin.myproject.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("message")
//@Primary
@Profile("tr")
public class MessageBeanTrImpl implements MessageBean {

	@Override
	public String getMessage() {
		return "Merhaba, nasılsınız?";
	}

}
