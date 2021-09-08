package prob5;

public class Prob5 {

	public static void main(String[] args) {
		for(int i = 1; i <= 99; i++) {
			int units = i%10;
			int tens = i/10;
			if (i<10) {  
				if(i%3==0)
				System.out.println(i+"짝");
			} else { 
				if ((tens%3 ==0) && (i%10 ==0))
					System.out.println(i+"짝");
				
				else if ((units%3 == 0) && (tens%3 ==0)) 
				System.out.println(i+"짝짝");
				
				else if ((units%3 == 0) || (tens%3 == 0))
					if (i%10 !=0)
						System.out.println(i+"짝");
			}
		}
	}
}
