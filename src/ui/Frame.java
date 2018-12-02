package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import player.Player;

public class Frame {
	JFrame frame = new JFrame("Find the X-it");
	JLabel title = new JLabel("Find the X-it");
	JLabel remainingTime = new JLabel("Time Left : ");
	JLabel time = new JLabel("60");
	JLabel remainingLife = new JLabel("Life : ");
	JLabel life = new JLabel("3");
	JLabel level = new JLabel("Level : ");
	public JLabel currentLevel = new JLabel("1");
	JLabel goal = new JLabel("Your Goal");
	JLabel player = new JLabel("Player");
	JLabel coin = new JLabel("Coin (Extra Time)");
	JLabel trap = new JLabel("It's a trap");
	JLabel pause = new JLabel("Press 'SPACE' to pause the game");
	JLabel exit = new JLabel("Hover             to show exit button");
	JLabel _this = new JLabel("THIS");
	JPanel gamepanel = new JPanel();
	JButton btnExit = new JButton("Exit");
	JLabel playerColorLabel;
	JLabel goalColorLabel;
	JLabel coinColorLabel;
	JLabel trapColorLabel;
	JLabel floorColorLabel;
	BufferedImage playerColor;
	BufferedImage goalColor;
	BufferedImage coinColor;
	BufferedImage trapColor;	
	BufferedImage floorColor;
	
	public Frame(){
		try {
			playerColor = ImageIO.read(new File("Asset/green.png"));
			goalColor = ImageIO.read(new File("Asset/blue.png"));
			coinColor = ImageIO.read(new File("Asset/yellow.png"));
			trapColor = ImageIO.read(new File("Asset/red.png"));
			floorColor = ImageIO.read(new File("Asset/white.png"));
			playerColorLabel = new JLabel(new ImageIcon(playerColor));
			goalColorLabel = new JLabel(new ImageIcon(goalColor));
			coinColorLabel = new JLabel(new ImageIcon(coinColor));
			trapColorLabel = new JLabel(new ImageIcon(trapColor));
			floorColorLabel = new JLabel(new ImageIcon(floorColor));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		title.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
		title.setBounds(600, 20, 200, 100);
		remainingTime.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		remainingTime.setBounds(600 , 90 , 200 , 100);
		time.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		time.setBounds(700 , 90 , 200 , 100);
		remainingLife.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		remainingLife.setBounds(600 , 110 , 200 , 100);
		life.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		life.setBounds(700 , 110 , 200 , 100);
		level.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		level.setBounds(600 , 130 , 200 , 100);
		currentLevel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		currentLevel.setBounds(700,130,200,100);
		
		goal.setBounds(640,180,200,100);
		goal.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		goalColorLabel.setBounds(510, 180, 200, 100);
		
		player.setBounds(640, 220, 200, 100);
		player.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		playerColorLabel.setBounds(510, 220, 200, 100);

		coin.setBounds(640 , 260,200,100);
		coin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		coinColorLabel.setBounds(510, 260, 200, 100);

		trap.setBounds(640, 300 , 200, 100);
		trap.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		trapColorLabel.setBounds(510, 300, 200, 100);
		
		pause.setBounds(600, 330, 300, 100);
		pause.setForeground(Color.MAGENTA);
		
		exit.setBounds(600,360, 300 , 100);
		exit.setForeground(Color.ORANGE);
		
		_this.setBounds(640, 360, 200, 100);
		_this.setForeground(Color.RED);
		_this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				btnExit.setVisible(true);
			}
		});
		
		btnExit.setBounds(650, 450, 60, 40);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});

		btnExit.setVisible(false);
		
		frame.add(title);
		frame.add(remainingTime);
		frame.add(time);
		frame.add(remainingLife);
		frame.add(life);
		frame.add(level);
		frame.add(currentLevel);
		frame.add(goal);
		frame.add(goalColorLabel);
		frame.add(player);
		frame.add(playerColorLabel);
		frame.add(coin);
		frame.add(coinColorLabel);
		frame.add(trap);
		frame.add(trapColorLabel);
		frame.add(pause);
		frame.add(exit);
		frame.add(_this);
		frame.add(btnExit);
		
		frame.setSize(900, 600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
}
