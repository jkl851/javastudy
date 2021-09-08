package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		int amount = scanner.nextInt();
		int unit = 0;
		
		for (int i=0; i<MONEYS.length; i++){
			unit = amount/MONEYS[i];
			amount%=MONEYS[i];
			
			System.out.printf("%d원 : %d개",MONEYS[i],unit);
			System.out.println();
		}
		scanner.close();
 	}
}