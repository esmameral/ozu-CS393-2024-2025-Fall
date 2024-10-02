package ozyegin.myproject.beans;

import java.text.SimpleDateFormat;

public interface GreetingService {
	public String sayHello() ;
	public int getARandomNumber();
	void setRandomNumber(int randomNumber);
	int getRandomNumber();
	void setMessageBean(MessageBean messageBean);
	MessageBean getMessageBean();
	void setDateFormat(SimpleDateFormat dateFormat);
	SimpleDateFormat getDateFormat();

}
