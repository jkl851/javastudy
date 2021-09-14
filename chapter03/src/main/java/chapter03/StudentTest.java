package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		s1.setName("도우너");
		System.out.println(s1.getName());
		
		Person p1 = s1;    // upcasting(암시적, Implicity)
		p1.setName("둘리");
		System.out.println(p1.getName());
		//((Person)s1).setName("둘리");
		
		Student s2 = (Student)p1;  // downcasting(명시적, explicity)
		s2.setMajor("cs");
	}

}
