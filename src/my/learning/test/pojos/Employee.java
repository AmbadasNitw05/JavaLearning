package my.learning.test.pojos;

public class Employee {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj2) {
		if(!(obj2 instanceof Employee)) {
			return false;
		}
		
		Employee e2 = (Employee)obj2;
		
		if(this.id == e2.getId() && (
				(this.name == null && e2.getName() == null) 
				|| (this.name != null && this.name.equals(e2.getName())))){
					return true;
				}
		return false;
	}
	
	
}
