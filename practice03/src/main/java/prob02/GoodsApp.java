package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for(int i=0; i<COUNT_GOODS; i++) {
			String input = scanner.nextLine();
			goods[i] = new Goods();
			goods[i].setName(input.split(" ")[0]);
			goods[i].setPrice(Integer.parseInt(input.split(" ")[1]));
			goods[i].setCountStock(Integer.parseInt(input.split(" ")[2]));
		}

		// 상품 출력
		for(int i=0; i<COUNT_GOODS; i++) {
			System.out.println(goods[i]);
		}
		// 자원정리
		scanner.close();
	}
}
