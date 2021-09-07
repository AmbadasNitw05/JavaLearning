package my.learning.test;

import java.util.Arrays;
import java.util.List;

// lambda provides implementation of functional interface (with only abstract method)
interface Sample1{
	public void print();
}

interface Sample2{
	public void print(String name);
}

interface Add{
	public int add(int a, int b);
}

public class LambdaExpression {

	public static void main(String[] args) {
		Sample1 s1 = () -> {
			System.out.println("lambda expression with empty parameter.");
		};
		
		s1.print();
		
		Sample2 s2 = (name) -> {
			System.out.println("lambda express with one parameter. value: " + name);
		};
		
		s2.print("Ambadas");
		
		Add addObj = (int a, int b) -> a+b;
		
		System.out.println("lambda expression with multi params. add: " + addObj.add(3, 5));
		
		System.out.println("lambda expression with forEach.");
		List<Integer> list = Arrays.asList(2,3,5,6);
		list.forEach(num -> {
			System.out.println(num);
		});
		
		System.out.println("lambda expression with thread.");
		Runnable r1 = () -> {
			System.out.println("Thread is starting."); // implements run() method
		};
		
		Thread t = new Thread(r1);
		t.start();
	}

}
