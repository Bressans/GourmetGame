package game.utilities;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import game.model.Dish;

public class Message {
	
	//Justify text of a JOptionPane
	private static JLabel justifyTextJOptionPane(String messageContent) {
		JLabel label = new JLabel(messageContent);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}

	public static int initializeGame() {
		Object[] options = { "Ok", "Fechar"};
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("Pense em um prato que você gosta."), "Gourmet Game", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
	
	public static int pastaQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que você pensou é massa?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}
	
	public static int lasanhaQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que você pensou é lasanha?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}

	public static void correctAnswer() {
		JOptionPane.showMessageDialog(null, justifyTextJOptionPane("Acertei de novo!"), "Gourmet Game", 1);
	}

	public static int cakeQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que você pensou é Bolo de Chocolate?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}

	public static String giveUpQuestion() {
		return JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
	}

	public static String completeMessage(String description, String dish) {
		return JOptionPane.showInputDialog(null, description + " é _______ mas " + dish + " não.", "Complete", 3);
	}

	public static int customDish(Dish dish) {
		
		if (JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + dish.getCharacteristic() + "?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {			
			return JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + dish.getDescription() + "?", "Confirm", JOptionPane.YES_NO_OPTION); 
		}
		return JOptionPane.NO_OPTION;
	}
}
