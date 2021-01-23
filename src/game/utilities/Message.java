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
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("Pense em um prato que voc� gosta."), "Gourmet Game", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
	
	public static int pastaQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que voc� pensou � massa?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}
	
	public static int lasanhaQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que voc� pensou � lasanha?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}

	public static void correctAnswer() {
		JOptionPane.showMessageDialog(null, justifyTextJOptionPane("Acertei de novo!"), "Gourmet Game", 1);
	}

	public static int cakeQuestion() {
		return JOptionPane.showConfirmDialog(null, justifyTextJOptionPane("O prato que voc� pensou � Bolo de Chocolate?"), "Confirm", JOptionPane.YES_NO_OPTION, 3);
	}

	public static String giveUpQuestion() {
		return JOptionPane.showInputDialog(null, "Qual prato voc� pensou?", "Desisto", 3);
	}

	public static String completeMessage(String description, String dish) {
		return JOptionPane.showInputDialog(null, description + " � _______ mas " + dish + " n�o.", "Complete", 3);
	}

	public static int customDish(Dish dish) {
		
		if (JOptionPane.showConfirmDialog(null, "O prato que voc� pensou � " + dish.getCharacteristic() + "?", "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {			
			return JOptionPane.showConfirmDialog(null, "O prato que voc� pensou � " + dish.getDescription() + "?", "Confirm", JOptionPane.YES_NO_OPTION); 
		}
		return JOptionPane.NO_OPTION;
	}
}
