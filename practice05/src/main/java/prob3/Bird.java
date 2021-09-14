package prob3;

public abstract class Bird {
	protected String name;
	
	public String Bird() {
		return name.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void sing(); 
	
	public abstract void fly();
}