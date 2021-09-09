package chapter03;

public class SwapTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		System.out.println(a + ":" + b);
		
		swap(a,b);
		
		System.out.println(a + ":" + b);

	}
	public static void swap(int num1, int num2) {
		int temp = num1;
		num1 = num2;
		num2 = temp; //결과 안바뀜
	}
	

}
