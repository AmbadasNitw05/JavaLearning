package my.learning.test;

class Test {

	public void method1 (int num1,float num2){
        System.out.println("int-float method");
   }
   public void method1(float num1,int num2){
        System.out.println("float-int method");
   }
    public static void main(String[] args){
          Test test=new Test();
         //  test.method1(40,20); -- Compilation error
          System.out.println("abcd1234abcde".substring(0,12));
    }

}


