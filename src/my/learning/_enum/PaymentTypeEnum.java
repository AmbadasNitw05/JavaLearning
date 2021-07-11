package my.learning._enum;

public enum PaymentTypeEnum {

	Credit("CR"),
	Debit("DB"),
	AccountPayment("AP"){
		@Override
		public boolean isSbiAccountPayment() {
			return true;
		}
	};
	
	private String type;
	
	private PaymentTypeEnum(String _type) {
		this.type = _type;
	}
	
	public String getType() {
		return this.type;
	}

	public boolean isSbiAccountPayment() {
		return false;
	}
	
	public static PaymentTypeEnum fromValue(String s) {
		for(PaymentTypeEnum pte: PaymentTypeEnum.values()) {
			if(pte.getType().equals(s)) {
				return pte;
			}
		}
		return null;
	}
}
