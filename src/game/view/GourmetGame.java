package game.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import game.model.Dish;
import game.model.DishMap;
import game.utilities.Message;

public class GourmetGame {
	
	private final List<DishMap> dishMap = new ArrayList<>();
	private final List<DishMap> dishMapCake = new ArrayList<>();

	public static void main(String[] args) {
		GourmetGame gourmetGame = new GourmetGame();
		gourmetGame.baseGame();
	}

	public void baseGame() {
		int initGame = Message.initializeGame();
		if (initGame == JOptionPane.NO_OPTION || initGame == JOptionPane.CLOSED_OPTION) {
			System.exit(1);
		}
		if (Message.pastaQuestion() == 0) {			
			if (!validateDish(this.dishMap)) { 
				if (Message.lasanhaQuestion() == 0) {
					Message.correctAnswer();
				} else {
					addDish("Lasanha", this.dishMap);
				}	
			}
		} else {
			if (!validateDish(this.dishMapCake)) { 
				if (Message.cakeQuestion() == 0) {
					Message.correctAnswer();
				} else {
					addDish("Bolo de Chocolate", this.dishMapCake);
				}	
			}
		}
		baseGame();
	}
	
	private boolean validateDish(List<DishMap> dishList) {
		for (DishMap dishMap : dishList) {
			int result = Message.validateCharacteristic(dishMap.getDish().getCharacteristic());
			if (result == JOptionPane.YES_OPTION) {
				if (dishMap.getDishMap() == null) {
					if (Message.customDish(dishMap.getDish().getDescription()) == JOptionPane.YES_OPTION) {
						Message.correctAnswer();
						return true;
					} else {
						List<DishMap> newDishList = new ArrayList<>();
						addDish(dishMap.getDish().getDescription(), newDishList);
						dishMap.setDishMap(newDishList);						
						return true;
					}
				} else {
					boolean validatedDish = validateDish(dishMap.getDishMap());			
					if (validatedDish) {
						return true;
					} else {
						if (Message.customDish(dishMap.getDish().getDescription()) == JOptionPane.YES_OPTION) {
							Message.correctAnswer();
							return true;
						} else {
							List<DishMap> newDishMap = dishMap.getDishMap();
							addDish(dishMap.getDish().getDescription(), newDishMap);
							dishMap.setDishMap(newDishMap);		
							return true;
						}
					}
				}
			} 
		} 
		return false;
	}

	public void addDish(String previousDescription, List<DishMap> newDishList) {
		String description = Message.giveUpQuestion();
		String characteristic = Message.completeMessage(description, previousDescription);
		newDishList.add(new DishMap(new Dish(description, characteristic)));
	}
	
	
}
