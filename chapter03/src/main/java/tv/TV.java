package tv;

public class TV {
	private int channel; // 1~255 
	private int volume;  // 0~100
	private boolean power;
	
	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public void status() {
		String powerStatus = "";
		if (power==true) powerStatus ="on";
		else powerStatus ="off";
		System.out.println("TV [channel=" + channel + ", volume=" + volume + ", power=" + powerStatus + "]");
	}
	
	public void power(boolean on) {
		if (on) this.power = on;
		else this.power = false;
	} 
	public void volume(int volume) {
		if (power == true) {
		if(volume < 100) this.volume = volume;
		else {
			if(volume > 100) this.volume = 100;
		}
		}
	}
	public void volume(boolean up) {
		if (power == true) {
		if (up && volume < 100) this.volume++;
		else { if(volume > 0) this.volume--;
		}
		}
	}
	public void channel(int channel) {
		if (power == true) {
		if(1 <= channel && channel <= 255) this.channel = channel;
		}
	}
	
	public void channel(boolean up) {
		if (power == true) {
		if (up && channel < 255) this.channel++;
		else {
			if(channel > 1) this.channel--;
		}
		}
	}
}

