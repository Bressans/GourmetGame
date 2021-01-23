package view;

import javax.swing.JOptionPane;

import model.Dish;
import model.DishList;
import utilities.Message;

public class GourmetGame {
	
	private DishList pastaDishes = new DishList();
	private DishList notPastaDishes = new DishList();

	public static void main(String[] args) {
		GourmetGame gourmetGame = new GourmetGame();
		gourmetGame.startGame();
	}
	
	private void startGame() {
		boolean play = true;
		while (play) {
			play = baseGame();
		}		
	}


	public boolean baseGame() {
		boolean correctAnswer = false;
		int initGame = Message.initializeGame();
		if (initGame == JOptionPane.NO_OPTION || initGame == JOptionPane.CLOSED_OPTION) {
			return false;
		}
		if (Message.pastaQuestion() == 0) {
			if (this.pastaDishes.getDishes().size() > 0) {
				for (int i = 0; i < this.pastaDishes.getDishes().size(); i++) {
					if (Message.customDish(this.pastaDishes, i) == JOptionPane.YES_OPTION) {
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
			if (this.notPastaDishes.getDishes().size() > 0) {
				for (int i = 0; i < this.notPastaDishes.getDishes().size(); i++) {
					if (Message.customDish(this.notPastaDishes, i) == JOptionPane.YES_OPTION) {
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
		return true;
	}
	
	public void addDish(String description, String characteristic, int pastaDish) {
		if (pastaDish == 0) {
			this.pastaDishes.getDishes().add(new Dish(description, characteristic));
		} else {
			this.notPastaDishes.getDishes().add(new Dish(description, characteristic));
		}		
	}
	
}
