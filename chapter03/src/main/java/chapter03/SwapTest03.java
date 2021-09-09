package chapter03;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);
		
		System.out.println(a.val + ":" + b.val);
		
		swap(a,b);
		
		System.out.println(a.val + ":" + b.val);

	}
	public static void swap(Value num1, Value num2) {
		int temp = num1.val;
		num1.val = num2.val;
		num2.val = temp; 
	}
	

}
