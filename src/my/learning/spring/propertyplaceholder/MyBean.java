package my.learning.spring.propertyplaceholder;

public class MyBean {

	private String welcomeMsg;

	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}
	
	public void greetMessage() {
		System.out.println(welcomeMsg);
	}
}
