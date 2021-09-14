package prob03;

public class Unit {
	// 현재 위치
	private int x;
	private int y;
	
	public Unit() {
	}

	void move(int x, int y) {
		System.out.println("좌표 "+ x + "," + y + "위치로 이동");
	}

	void stop() {
		System.out.println( x+ "," + y + " 위치에 정지");
	}

}
