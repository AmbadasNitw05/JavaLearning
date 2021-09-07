package my.learning.test;

import java.io.Serializable;

interface Permission{
	// Marker interfaces as it doesn't have any members and methods
}

// Serializable is best example of Marker Interface
public class MarkerInterfaceExample implements Permission, Serializable{
	
	public void show() {
		System.out.println("show something because it has permission");
	}

	public static void main(String[] args) {
		MarkerInterfaceExample obj = new MarkerInterfaceExample();
		if(obj instanceof Permission) {
			System.out.println("obj has permission: ");
			obj.show();
		}else {
			System.out.println("object doesn't have permission");
		}

	}

}
