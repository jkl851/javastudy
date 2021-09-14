package prob03;

public class Starcraft {

	public static void main(String[] args) {
		Tank tank = new Tank ();
		tank.changeMode();
		tank.move(10, 20);
		
		Marine marine = new Marine ();
		marine.stimPack();
		marine.move(40, 60);
		
		DropShip dropship = new DropShip ();
		dropship.load();
		dropship.unload();
		dropship.move(100, 200);

	}

}
