package game.model;

public class Dish {

	private String description;
	
	private String characteristic;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}	

	public Dish(String description, String characteristic) {
		this.description = description;
		this.characteristic = characteristic;
	}
	
}
