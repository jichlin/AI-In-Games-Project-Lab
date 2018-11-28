package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	JFrame frame = new JFrame("Find the X-it");
	JLabel title = new JLabel("Find the X-it");
	JLabel remainingTime = new JLabel("Time Left : ");
	JLabel life = new JLabel("Life : ");
	JLabel level = new JLabel("Level : ");
	JLabel goal = new JLabel("Your Goal");
	JLabel player = new JLabel("Player");
	JLabel coin = new JLabel("Coin (Extra Time)");
	JLabel trap = new JLabel("It's a trap");
	JLabel pause = new JLabel("Press SPACE to pause the game");
	JLabel exit = new JLabel("Hover THIS to show exit button");
	JPanel gamepanel = new JPanel();
}
