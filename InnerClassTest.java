package com.gac.oj;

/**
 * 理解非静态内部类，静态内部类，匿名内部类，局部内部类
 * 
 * @author gz04766
 *
 */
public class InnerClassTest {

	public void a(A a) {
		System.out.println("#################");
		a.aa();
	}
	
	//局部内部类
	public void show(){
        class Inner{
            public void fun(){
                System.out.println("HelloWorld");
            }
        }
        new Inner().fun();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//非静态内部类
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
		
		//静态内部类
		Outer1.Inner inner1 = new Outer1.Inner();
		inner1.show();
		
		//匿名内部类
		InnerClassTest ict = new InnerClassTest();
		ict.a(new A() {

			@Override
			public void aa() {
				// TODO Auto-generated method stub
				System.out.println("I'm the anonymousclass's  function.");
			}
			
		});
		
		ict.show();
	}
	
}

//非静态内部类
class Outer{
     private int age=90;
     public void run() {
           System.out.println("Run");
     }
     //定义内部类
     class Inner{
           private int age=10;
           public void show() {
                  System.out.println("Inner's age is:"+age);//10
                  System.out.println("Outer's age is:"+Outer.this.age);//90
                  int age = 5;
                  System.out.println("Local variable's age is:"+age);//5

           }
     }
}

//静态内部类
class Outer1{
     private int age=90;
     public void run() {
           System.out.println("Run");
     }
     //定义内部类
     static class Inner{
           private static int age=10;
           public void show() {
                  System.out.println("Inner's age is:"+age);
                  //错误，不能访问外部类的非static成员
                  //System.out.println("Outer's age is:"+Outer1.this.age);
                  int age = 5;
                  System.out.println("Local variable's age is:"+age);

           }
     }
}

//匿名内部类：适合那种只需要使用一次的类，比如键盘监听操作,监听点击事件等等
interface A{
    public void aa();
}