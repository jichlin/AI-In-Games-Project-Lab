package ui;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import game.GamePanel;
import player.Stats;

public class Frame extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelHelp = new JPanel();
	GamePanel gamePanel = new GamePanel();
	Stats status = gamePanel.getStatus();
	
	JLabel title = new JLabel("Find the X-it");
	JLabel pausedLabel = new JLabel("GAME PAUSED");
	JLabel remainingTime = new JLabel("Time Left : ");
	JLabel time = new JLabel(Integer.toString(status.getTime()));
	JLabel remainingLife = new JLabel("Life : ");
	JLabel life = new JLabel(Integer.toString(status.getLife()));
	JLabel level = new JLabel("Level : ");
	JLabel currentLevel = new JLabel(Integer.toString(status.getLevel()));
	JLabel goal = new JLabel("Your Goal");
	JLabel player = new JLabel("Player");
	JLabel coin = new JLabel("Coin (Extra Time)");
	JLabel trap = new JLabel("It's a trap");
	JLabel pause = new JLabel("Press 'SPACE' to pause the game");
	JLabel exit = new JLabel("Hover             to show exit button");
	JLabel _this = new JLabel("THIS");
	JButton btnExit = new JButton("Exit");
	JSplitPane split = new JSplitPane();
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
	Thread timeThread = new Thread(this);

	void initComponents(){
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
		split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		
		setTitle("Find the X-it");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		panelHelp.setSize(450, 600);
		panelHelp.setLayout(null);
		title.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
		title.setBounds(100, 10, 200, 100);
		pausedLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		pausedLabel.setBounds(100, 50, 200, 100);
		pausedLabel.setVisible(false);
		remainingTime.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		remainingTime.setBounds(100 , 90 , 200 , 100);
		
		time.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
		time.setBounds(200 , 90 , 200 , 100);
		
		remainingLife.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		remainingLife.setBounds(100 , 110 , 200 , 100);
		
		life.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
		life.setBounds(200 , 110 , 200 , 100);
		
		level.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		level.setBounds(100 , 130 , 200 , 100);
		
		currentLevel.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
		currentLevel.setBounds(200,130,200,100);
		
		goal.setBounds(140,180,200,100);
		goal.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		goalColorLabel.setBounds(10, 180, 200, 100);
		
		player.setBounds(140, 220, 200, 100);
		player.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		playerColorLabel.setBounds(10, 220, 200, 100);

		coin.setBounds(140 , 260,200,100);
		coin.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		coinColorLabel.setBounds(10, 260, 200, 100);

		trap.setBounds(140, 300 , 200, 100);
		trap.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
		trapColorLabel.setBounds(10, 300, 200, 100);
		
		pause.setBounds(100, 330, 300, 100);
		pause.setForeground(Color.MAGENTA);
		
		exit.setBounds(100,360, 300 , 100);
		exit.setForeground(Color.ORANGE);
		
		_this.setBounds(140, 360, 200, 100);
		_this.setForeground(Color.RED);
		_this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me){
				btnExit.setVisible(true);
			}
		});
		
		btnExit.setBounds(150, 450, 60, 40);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(1);
			}
		});
		
		btnExit.setVisible(false);
		panelHelp.add(title);
		panelHelp.add(pausedLabel);
		panelHelp.add(remainingTime);
		panelHelp.add(time);
		panelHelp.add(remainingLife);
		panelHelp.add(life);
		panelHelp.add(level);
		panelHelp.add(currentLevel);
		panelHelp.add(goal);
		panelHelp.add(goalColorLabel);
		panelHelp.add(player);
		panelHelp.add(playerColorLabel);
		panelHelp.add(coin);
		panelHelp.add(coinColorLabel);
		panelHelp.add(trap);
		panelHelp.add(trapColorLabel);
		panelHelp.add(pause);
		panelHelp.add(exit);
		panelHelp.add(_this);
		panelHelp.add(btnExit);
		panelHelp.setVisible(true);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setSize(900,600);
		
		
		split.setRightComponent(panelHelp);
		split.setLeftComponent(gamePanel);
		split.setDividerLocation(460);
		add(split);
	}
	
	void view(){
		setVisible(true);
	}
	
	public Frame(){
		initComponents();
		view();
		timeThread.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(status.getTime() != -1){
				status = gamePanel.getStatus();
				if(status.getPaused() == false){
					pausedLabel.setVisible(false);
					gamePanel.setFocusable(true);
					if(status.getLife() == 0){
						break;
					}
					
					if(status.isTrapStepped()){
					}
					
					if(status.isCoinStepped()){
						time.setText(Integer.toString(status.getTime()));
					}

					int t = status.getTime();
					String temp = Integer.toString(t);
					
					int level = status.getLevel();
					String l = Integer.toString(level);
					
					int life = status.getLife();
					String li = Integer.toString(life);
					
					time.setText(temp);
					this.life.setText(li);
					this.currentLevel.setText(l);
					
					status.setTime(t - 1);	
					Thread.sleep(1000);
				}
				else{
					pausedLabel.setVisible(true);
				}
			}
			this.life.setText("0");
			JOptionPane.showConfirmDialog(this, "Game Over", "Try Again", JOptionPane.DEFAULT_OPTION);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
