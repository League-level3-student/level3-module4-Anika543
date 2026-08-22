package _03_Hangman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {

	String currentWord;
	StringBuilder x; 
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("Lives: ");
	JLabel incorrectGuesses = new JLabel("Incorrect Guesses: "); 
	int lives = 5;

	public void run() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(label);
		panel.add(label2);
		panel.add(incorrectGuesses);

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

		currentWord = words.pop();
		x=new StringBuilder(currentWord); 
		for (int i = 0; i < currentWord.length(); i++) {
			label.setText(label.getText() + "_ ");

		}
		label.setText(label.getText() +currentWord);

		label2.setText(lives + "");
		label2.setForeground(Color.RED);
		frame.pack();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
//		if (currentWord.contains(e.getKeyChar() + "")) {
//			StringBuilder labelText = new StringBuilder(label.getText());
//			if(currentWord.charAt(currentWord.indexOf(e.getKeyChar())) == '_'){
//				labelText.setCharAt(currentWord.indexOf(e.getKeyChar()) * 2, e.getKeyChar());
//			}else if()
		char key = e.getKeyChar();
		if(x.indexOf(key + "") == -1) {
			lives--; 
			label2.setText(lives +"");
			incorrectGuesses.setText(incorrectGuesses.getText() + key );
		}
		while (x.indexOf(key + "") >= 0) {
			StringBuilder labelText = new StringBuilder(label.getText());
			labelText.setCharAt(x.indexOf(key + "") * 2, key);
			x.setCharAt(x.indexOf(key+""), '.');
			label.setText(labelText.toString());
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// reset lives

}
