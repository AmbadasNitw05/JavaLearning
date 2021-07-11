package my.learning._enum;

public class EnumMainApp {

	public static void main(String[] args) {
		
		for(PaymentTypeEnum et1: PaymentTypeEnum.values()) {
			System.out.println(et1.getType());
		}
		
		System.out.println(PaymentTypeEnum.fromValue("DB"));
	}
}
