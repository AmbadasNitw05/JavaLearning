package my.learning.test;

public class ClassLoaderTest {

	public static void main(String[] args) {
		// Bootstrap classloader loads all core libraries like java.lang.* etc
		// Extension classloader loads the classes at $JAVA_HOME$/lib/ext folder
		// Application or System classloader loads classes from classpath including our own app classes
		System.out.println("ClassLoaderTest.class.getClassLoader() : " + ClassLoaderTest.class.getClassLoader());
		System.out.println("String.class.getClassLoader() : " + String.class.getClassLoader());
	}

}
