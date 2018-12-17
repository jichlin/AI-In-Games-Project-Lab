package map;

import java.util.LinkedList;
import java.util.Random;

public class Map {
	public static char trap = 'T';
	public static char coin = 'C';
	public static char wall = '=';
	public static char player = 'P';
	public static char floor = '.';
	public static char goal = 'G';
	public static int width = 21;
	public static int height = 21;  
	public char map[][] = new char[width + 2][height + 2];
	Random random = new Random();
	int playerX;
	int playerY;


	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	
	public void randomizedMaze(){
		LinkedList<int[]> cekWall = new LinkedList<int[]>();
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		cekWall.add(new int[]{x, y , x , y});
		
		while(!cekWall.isEmpty()){
			int[] f = cekWall.remove(random.nextInt(cekWall.size()));
			x = f[2];
			y = f[3];
			if(map[y][x] == wall){
				map[f[1]][f[0]] = map[y][x] = floor;
				if( y >= 2 && map[y-2][x] == wall){
					cekWall.add(new int[]{x , y - 1 , x ,  y - 2});
				}
				if( x >= 2 && map[y][x-2] == wall){
					cekWall.add(new int[]{x - 1 , y , x - 2,  y});
				}
				if( y < width - 2 && map[y + 2][x] == wall){
					cekWall.add(new int[]{x , y + 1 , x,  y + 2});
				}
				if( x < height - 2 && map[y][x + 2] == wall){
					cekWall.add(new int[]{x + 1 , y , x + 2,  y});
				}
			}
		}
				
	}	
	
	public void printmap(){
		for(int i = 0 ; i < height + 2 ; i++){
			for(int j = 0 ;j < width + 2 ; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	void init(){
		for(int i = 0; i < height; i++){
			for(int j = 0 ; j < width ; j++){
				map[i][j] = wall;
			}
		}
	}
	
	void border(){
		char temp[][] = new char[height + 2][width +2];
		for(int i = 0; i < height + 1; i++){
			for(int j = 0 ; j < width + 1 ; j++){
				temp[i+1][j+1] = map[i][j];
			}
		}
		
		for(int i = 0; i < height + 2; i++){
			for(int j = 0 ; j < width + 2 ; j++){
				if(i == 0 || i == 22 || j == 0 || j == 22){
					temp[i][j] = wall;
				}
			}
		}
		map = temp;
		
	}
	
	void generateCoin(){
		int count = 0;
		while(count != 5){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			
			if(map[y][x] != wall && map[y][x] != trap){
				map[y][x] = coin;
				count++;
			}
			
		}
	}
	
	void generateTrap(){
		int count = 0;
		while(count != 3){
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			
			if(map[y][x] != wall && map[y][x] != coin){
				map[y][x] = trap;
				count++;
			}		
		}
	}
	
	void generatePlayer(){
		boolean flag = false;
		for(int i = 1 ; i < 3 ;i++){
			for(int j = 0 ; j < width ; j++ ){
				if(map[i][j] != wall && map[i][j] != trap && map [i][j] != coin){
					map[i][j] = player;
					playerX = j;
					playerY = i;
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	void generateGoal(){
		boolean flag = false;
		for(int i = 22 ; i > 19 ;i--){
			for(int j = 22 ; j > 0 ; j-- ){
				if(map[i][j] != wall && map[i][j] != trap && map [i][j] != coin){
					map[i][j] = goal;
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
	}
	
	public void generateMaze(){
		init();
		randomizedMaze();
		border();
		generateCoin();
		generateTrap();
		generatePlayer();
		generateGoal();
	}
	
	public Map(){
		generateMaze();
	}
}
