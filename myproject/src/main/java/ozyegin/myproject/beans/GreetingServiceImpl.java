package ozyegin.myproject.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greetingService")
//@Scope("prototype")
public class GreetingServiceImpl implements GreetingService {
	
	@Autowired
	@Qualifier("enMessage")
	private MessageBean messageBean;
	
	
	@Autowired
	@Qualifier("dateFormat")
	private SimpleDateFormat dateFormat;
	
	@Override
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}


	@Override
	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}


	@Override
	public MessageBean getMessageBean() {
		return messageBean;
	}


	@Override
	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
	}

	private int randomNumber=(int)(Math.random()*1000);

	
	
	

	@Override
	public int getRandomNumber() {
		return randomNumber;
	}

	@Override
	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public String sayHello() {
		
		return messageBean.getMessage()+"\n "+"Current Date:"+dateFormat.format(new Date());
	}

	@Override
	public int getARandomNumber() {
		
		return randomNumber;
	}

}
