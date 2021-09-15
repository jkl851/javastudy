package prob5;

public class MyStack {
	public int num = 0;
	public String[] arr;
	public int count = 0;

	public MyStack(int a) {
		num = a;
		arr = new String[num];
		/**
		 * MyStack push() isEmpty() pop() MyStackException
		 */
	}

	public void push(String obj) {
		if (count == num) {
			String[] buffer = new String[num + 1];
			for(int i =0; i<num; i++) {
				buffer[i] = arr[i];
			}
			buffer[num] = obj;
			arr = buffer;
			num++;
			count++;
		} else {
			arr[count] = obj;
			count++;
		}
	}

	public boolean isEmpty() {
		if (count == 0)
			return true;
		else
			return false;
	}

	public String pop() throws MyStackException {
		//꺼낼것이 있는지 (배열이 비어있는)확인 비어있으면 비어있습니다. 라고 띄우고 안비어
		if(count > 0) {
			String temp = arr[count-1];
			arr[count-1] = null;
			count--;
			return temp;
		} else {
			throw new MyStackException();
		}
	}

}