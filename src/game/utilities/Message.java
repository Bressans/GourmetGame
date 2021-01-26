package game.utilities;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Message {
	
	private static final Object[] options = { "Sim", "Não"};
	
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
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que você pensou é massa?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
	
	public static int lasanhaQuestion() {
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que você pensou é lasanha?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static void correctAnswer() {
		JOptionPane.showMessageDialog(null, justifyTextJOptionPane("Acertei de novo!"), "Gourmet Game", 1);
	}

	public static int cakeQuestion() {
		return JOptionPane.showOptionDialog(null, justifyTextJOptionPane("O prato que você pensou é Bolo de Chocolate?"), "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}

	public static String giveUpQuestion() {
		return JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
	}

	public static String completeMessage(String description, String dish) {
		return JOptionPane.showInputDialog(null, description + " é _______ mas " + dish + " não.", "Complete", 3);
	}

	public static int customDish(String description) {				
		if (JOptionPane.showOptionDialog(null, "O prato que você pensou é " + description + "?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {
			return JOptionPane.YES_OPTION;				 
		} 
		return JOptionPane.NO_OPTION;
	}
	
	public static int validateCharacteristic(String characteristic) {
		if (JOptionPane.showOptionDialog(null, "O prato que você pensou é " + characteristic + "?", "Confirm", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == JOptionPane.YES_OPTION) {		
			return JOptionPane.YES_OPTION;
		}
		return JOptionPane.NO_OPTION;
	}
}
