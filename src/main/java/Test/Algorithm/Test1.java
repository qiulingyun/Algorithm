package Test.Algorithm;

public class Test1 {

	public Test1(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		System.out.println(System.identityHashCode(a));
		a = "bcd";
		System.out.println(System.identityHashCode(a));
		a = new String("111");
		System.out.println(System.identityHashCode(a));
		String b = "abc";
		System.out.println(System.identityHashCode(b));
		
	}

}
