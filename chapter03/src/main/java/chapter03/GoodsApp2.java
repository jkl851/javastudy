package chapter03;

import mypakage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		
		
		// pubilc은 접근제한이 없다.
		g.name = "camera";
		
		// protected는 같은 패키지에서 접근 가능
		// 더 중요한 것은 자식에서도 접근이 가능하다.
		// g.price = 1000;
		
		
		// 디폴트는 같은 패키지에서만 접근이 가능하다.
		// g.countStock = 10;
		
		// private은 같은 클래스에서만 접근이 가능하다.
		// g.countSold = 10;
	}

}