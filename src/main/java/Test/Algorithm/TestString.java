package Test.Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String a = new String("Alex") + new String("Qiu");
//		System.out.println("a address:" + System.identityHashCode(a));
		System.out.println("a.intern = a ?" + (a.intern() == a));
//		System.out.println("a address:" + System.identityHashCode(a));
		System.out.println("a == AlexQiu ?" + (a == "AlexQiu"));
		
		String s1 = "abc";
		String s2 = "a";
		String s3 = "bc";
		System.out.println(s1 == (s2 + s3));
//		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		reader.readLine();
		
	}

}
