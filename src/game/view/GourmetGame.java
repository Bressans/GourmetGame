package game.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import game.model.Dish;
import game.utilities.Message;

public class GourmetGame {
	
	private final List<Dish> pastaDishes = new ArrayList<>();
	private final List<Dish> notPastaDishes = new ArrayList<>();

	public static void main(String[] args) {
		GourmetGame gourmetGame = new GourmetGame();
		gourmetGame.baseGame();
	}

	public void baseGame() {
		boolean correctAnswer = false;
		int initGame = Message.initializeGame();
		if (initGame == JOptionPane.NO_OPTION || initGame == JOptionPane.CLOSED_OPTION) {
			System.exit(1);
		}
		if (Message.pastaQuestion() == 0) {
			if (this.pastaDishes.size() > 0) {
				for (Dish dish : this.pastaDishes) {
					if (Message.customDish(dish) == JOptionPane.YES_OPTION) {
						Message.correctAnswer();
						correctAnswer = true;
					} 
				}
			}
			if (!correctAnswer) {
				if (Message.lasanhaQuestion() == 0) {
					Message.correctAnswer();
				} else {
					String description = Message.giveUpQuestion();
					String characteristic = Message.completeMessage(description, "Lasanha");
					addDish(description, characteristic, 0);
				}				
			}
		} else {
			if (this.notPastaDishes.size() > 0) {
				for (Dish dish : this.notPastaDishes) {
					if (Message.customDish(dish) == JOptionPane.YES_OPTION) {
						Message.correctAnswer();
						correctAnswer = true;
					} 
				}
			}
			if (!correctAnswer) {
				if (Message.cakeQuestion() == 0) {
					Message.correctAnswer();
				} else {
					String description = Message.giveUpQuestion();
					String characteristic = Message.completeMessage(description, "Bolo de Chocolate");
					addDish(description, characteristic, 1);
				}				
			}
		}
		baseGame();
	}
	
	public void addDish(String description, String characteristic, int pastaDish) {
		if (pastaDish == 0) {
			this.pastaDishes.add(new Dish(description, characteristic));
		} else {
			this.notPastaDishes.add(new Dish(description, characteristic));
		}		
	}
	
}
