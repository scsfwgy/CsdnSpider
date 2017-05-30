package test;

/**
 * @author wgyscsf
 * @email wgyscsf@163.com
 * @dateTime 2017 2017-4-14 下午1:40:50
 * @details 
 */
public class Test {
 int a;
 String b;
 void set(int a,String b){
	 this.a=a;
	 this.b=b;
 }
 public static void main(String[] args) {
	Test test=new Test();
	test.set(1, "abc");
	
	Test test2=new Test();
	test2.set(2, "abc2");
	
	System.out.println(test.a+"--"+test.b);
	System.out.println(test2.a+"--"+test2.b);
}

}
