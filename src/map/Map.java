package map;

public class Map {
	public char map[][] = new char[21][21];
	public static char trap = 'T';
	public static char coin = 'C';
	public static char wall = '=';
	public static char player = 'P';
	public static char floor = '.';
	public static char goal = 'G';
	public static int width = 20;
	public static int height = 20;  
	
	public void randomizedMaze(){
		
	}
	
	public void printmap(){
		for(int i = 0 ; i < height ; i++){
			for(int j = 0 ;j < width ; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	void init(){
		for(int i = 0; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				map[i][j] = wall;
			}
		}
		
		for(int i = 1; i < height - 1 ; i++){
			for(int j = 1 ; j < width - 1 ; j++){
				map[i][j] = floor;
			}
		}
		
		
		map[1][1] = player;
		
		map[3][3] = trap;
		map[5][5] = coin;
		
		map[17][17] = goal;
		
	}
	
	public Map(){
		init();
	}
}
