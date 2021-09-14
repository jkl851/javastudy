package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2); //false
		System.out.println(s1.equals(s2)); //true
		System.out.println(s1.hashCode()+ ":" + s2.hashCode()); //99162322:99162322
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); //366712642:1829164700
		
		System.out.println("=========================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); //true
		System.out.println(s3.equals(s4)); //true
		System.out.println(s3.hashCode() + ":" + s4.hashCode()); //99162322:99162322
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4)); //2018699554:2018699554
	}

}
