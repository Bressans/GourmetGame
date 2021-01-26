package game.utilities;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Message {
	
	private static final Object[] options = { "Sim", "N�o"};
	
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
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que voc� pensou � massa?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
	
	public static int lasanhaQuestion() {
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que voc� pensou � lasanha?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static void correctAnswer() {
		JOptionPane.showMessageDialog(null, justifyTextJOptionPane("Acertei de novo!"), "Gourmet Game", 1);
	}

	public static int cakeQuestion() {
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que voc� pensou � Bolo de Chocolate?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static String giveUpQuestion() {
		return JOptionPane.showInputDialog(null, "Qual prato voc� pensou?", "Desisto", 3);
	}

	public static String completeMessage(String description, String dish) {
		return JOptionPane.showInputDialog(null, description + " � _______ mas " + dish + " n�o.", "Complete", 3);
	}

	public static int customDish(String description) {				
		if (JOptionPane.showOptionDialog(null, "O prato que voc� pensou � " + description + "?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
			return JOptionPane.YES_OPTION;				 
		} 
		return JOptionPane.NO_OPTION;
	}
	
	public static int validateCharacteristic(String characteristic) {
		if (JOptionPane.showOptionDialog(null, "O prato que voc� pensou � " + characteristic + "?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {		
			return JOptionPane.YES_OPTION;
		}
		return JOptionPane.NO_OPTION;
	}
}
