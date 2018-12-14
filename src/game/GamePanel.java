package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import map.Map;
import player.Stats;

public class GamePanel extends JPanel implements Runnable , KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	Color white = new Color(255,255,255);
	Color black = new Color(0,0,0);
	Color coin = new Color(251,192,45);
	Color player = new Color(7,247,35);
	Color trap = new Color(237,2,10);
	Color exit = new Color(0,195,229);
	Map map = new Map();
	Graphics2D g2d;
	int playerX = 1;
	int playerY = 1;
	Stats status = new Stats();
	Thread gameThread = new Thread(this);

	public GamePanel(){
		setSize(400, 400);
		addKeyListener(this);
		setFocusable(true);
		gameThread.start();
	}
	
	public Stats getStatus(){
		return status;
	}
	
	
	public void drawMap(){
		for(int i = 0 ; i < Map.height ; i++){
			for(int j = 0 ; j < Map.width; j++){
				if(map.map[i][j] == Map.wall){
					g2d.setColor(black);
				}
				else if(map.map[i][j] == Map.floor){
					g2d.setColor(white);
				}
				else if(map.map[i][j] == Map.player){
					g2d.setColor(player);
				}
				else if(map.map[i][j] == Map.goal){
					g2d.setColor(exit);
				}
				else if(map.map[i][j] == Map.coin){
					g2d.setColor(coin);
				}
				else if(map.map[i][j] == Map.trap){
					g2d.setColor(trap);
				}
				g2d.fillRect(i * Map.width , j * Map.height, 20, 20);
			}
		}
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g2d = (Graphics2D)g;
		drawMap();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){			
			repaint();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	void checkSpecialTile(){
		if(map.map[playerY][playerX] == Map.coin){
			status.setTime(status.getTime() + 5);
			status.setCoinStepped(true);
		}
		else if(map.map[playerY][playerX] == Map.trap){
			status.setLife(status.getLife() - 1);
			status.setTrapStepped(true);
		}
		else if(map.map[playerY][playerX] == Map.goal){
			status.setLevel(status.getLevel() + 1);
		}
	}
		
	@Override
	public void keyPressed(KeyEvent k) {
		// TODO Auto-generated method stub
		int code =  k.getKeyCode();
		if( code == KeyEvent.VK_W && status.getPaused() != true){
			if(map.map[playerY][playerX-1] != Map.wall){
				map.map[playerY][playerX] = Map.floor;
				playerX -= 1;
			}
		}
		else if(code == KeyEvent.VK_S && status.getPaused() != true){
			if(map.map[playerY][playerX+1] != Map.wall){
				map.map[playerY][playerX] = Map.floor;
				playerX += 1;
			}
		}
		else if(code == KeyEvent.VK_A && status.getPaused() != true){
			if(map.map[playerY-1][playerX] != Map.wall){
				map.map[playerY][playerX] = Map.floor;
				playerY -= 1;
			}
		}
		else if(code == KeyEvent.VK_D && status.getPaused() != true){
			if(map.map[playerY +1][playerX] != Map.wall){
				map.map[playerY][playerX] = Map.floor;
				playerY += 1;
			}
		}
		else if(code == KeyEvent.VK_SPACE){
			if(status.getPaused() == false){
				status.setPaused(true);
			}
			else{
				status.setPaused(false);				
			}
				
			
		}
		checkSpecialTile();
		map.map[playerY][playerX] = Map.player;	
		map.printmap();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
