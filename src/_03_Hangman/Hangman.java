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
	JFrame frame = new JFrame();
	Stack<String> words = new Stack<String>();
	StringBuilder x;
	JLabel label = new JLabel();
	JLabel label2 = new JLabel("Lives: ");
	JLabel incorrectGuesses = new JLabel("Incorrect Guesses: ");
	JLabel wordsSolvedLabel = new JLabel(); 
	int wordsSolved = 0; 
	int wordCount; 
	int lives = 6;
	boolean isPlaying = true;

	public void run() {
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.add(label);
		panel.add(label2);
		panel.add(incorrectGuesses);
		panel.add(wordsSolvedLabel); 

		frame.pack();
		setNumberOfWords(); 
		
	}
	
	//sets the amount of words the user wants to play with
	public void setNumberOfWords() {
		String s = JOptionPane.showInputDialog(null,
				"Enter the number of words you would like to use \n (Less than 266)");
		wordCount = Integer.parseInt(s);
		frame.setVisible(true);

		for (int i = 0; i < wordCount; i++) {
			String temp = Utilities.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(temp)) {
				words.push(temp);
			} else {
				i--;
			}
		}
		wordsSolvedLabel.setText(wordsSolved + "/" + wordCount);
		setWord();

		
	}
	
	//sets the current word on the frame
	public void setWord() {
		label.setText("");
		currentWord = words.pop();
		x = new StringBuilder(currentWord);
		for (int i = 0; i < currentWord.length(); i++) {
			label.setText(label.getText() + "_ ");

		}
		label.setText(label.getText() + currentWord);

		label2.setText(lives + "");
		label2.setForeground(Color.RED);
		frame.pack();

	}
	
	//if they complete the game and win
	public void gameCompleted() {
		if(wordsSolved == wordCount) {
			int playAgain = JOptionPane.showConfirmDialog(null,
					"You won! Would you like to play again?", null,
					JOptionPane.YES_NO_OPTION);
			if (playAgain == JOptionPane.YES_OPTION) {
				lives = 6;
				incorrectGuesses.setText("Incorrect Guesses: ");
				wordsSolved = 0; 
				wordsSolvedLabel.setText(wordsSolved + "/" + wordCount); 
//				if(!words.isEmpty()) {
//					words.pop(); 
//				}
				setNumberOfWords();
				setWord(); 
			} else {

			}
		}
	}
	
	public void gameLost() {
		int playAgain = JOptionPane.showConfirmDialog(null,
				"You lost. The correct answer was " + currentWord + ". \nWould you like to play again?", null,
				JOptionPane.YES_NO_OPTION);
		if (playAgain == JOptionPane.YES_OPTION) {
			lives = 6;
			incorrectGuesses.setText("");
			wordsSolved = 0; 
			wordsSolvedLabel.setText(wordsSolved + "/" + wordCount); 
			setNumberOfWords();
			setWord(); 
		} else {

		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char key = e.getKeyChar();
		
		//if they guess wrong
		if (x.indexOf(key + "") == -1) {
			lives--;
			label2.setText(lives + "");
			incorrectGuesses.setText(incorrectGuesses.getText() + key);
			frame.pack();
		}
		
		StringBuilder labelText = new StringBuilder(label.getText());
		
		//if they guess right
		while (x.indexOf(key + "") >= 0) {
			labelText.setCharAt(x.indexOf(key + "") * 2, key);
			x.setCharAt(x.indexOf(key + ""), '.');
			label.setText(labelText.toString());
			frame.pack();
		}
		
		//if they solve a word that isn't the last word
		if (labelText.indexOf("_") == -1 && wordsSolved<wordCount-1 && !words.isEmpty()) {
			setWord();
			wordsSolved++; 
			wordsSolvedLabel.setText(wordsSolved + "/" + wordCount);
		}
		//if they solve the last word, calls gameCompleted
		else if(labelText.indexOf("_") == -1 && wordsSolved==wordCount-1) {
			wordsSolved++; 
			wordsSolvedLabel.setText(wordsSolved + "/" + wordCount);
			gameCompleted(); 
		}
		
		
		//if they run out of lives, calls gameLost
		if (lives == 0) {
			gameLost(); 
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
