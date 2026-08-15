package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {

	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel();
		panel.add(label);

		frame.pack();

		String s = JOptionPane.showInputDialog(null,
				"Enter the number of words you would like to use \n (Less than 266)");
		int wordCount = Integer.parseInt(s);

		Stack<String> words = new Stack<String>();
		for (int i = 0; i < wordCount; i++) {
			String temp = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(temp)) {
				words.push(temp);
			} else {
				i--;
			}
		}

		for (int i = 0; i < words.pop().length(); i++) {

			label.setText(label.getText() + "_ " );
		}

	}

	// reset lives

}
