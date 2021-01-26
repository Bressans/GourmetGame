package game.model;

import java.util.List;

public class DishMap {
	
	private Dish dish;
	
	private List<DishMap> dishMap;

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public List<DishMap> getDishMap() {
		return dishMap;
	}

	public void setDishMap(List<DishMap> dishMap) {
		this.dishMap = dishMap;
	}

	public DishMap (Dish dish) {
		this.dish = dish;
	}
}
