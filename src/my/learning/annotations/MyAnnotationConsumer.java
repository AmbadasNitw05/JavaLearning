package my.learning.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAnnotationConsumer {

	public static void main(String[] args){
		Class myAnnotationClientClass = MyAnnotationClient.class;
		for(Method method: myAnnotationClientClass.getMethods()){
			MyAnnotation myAnnotation = (MyAnnotation)method.getAnnotation(MyAnnotation.class);
			if(myAnnotation != null){
				System.out.println("method name: " + method.getName());
				System.out.println("author: " + myAnnotation.author());
				System.out.println("priority: " + myAnnotation.priority());
				System.out.println("sequenceNumber: " + myAnnotation.sequenceNumber());
				System.out.println("supporters: " + Arrays.toString(myAnnotation.supporters()));
				System.out.println("allowedType: " + myAnnotation.allowedType());
			}
			
		}
	}
}
