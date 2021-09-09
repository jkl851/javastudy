package prob01;

public class MemberApp {

	public static void main(String[] args) {
		Member member = new Member();
		member.setId("abcd");
		member.setName("Nick");
		member.setPoint(10000);
		System.out.println(member.getId());
		System.out.println(member.getName());
		System.out.println(member.getPoint());
	}

}
