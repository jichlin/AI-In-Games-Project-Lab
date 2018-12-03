package map;

public class Map {
	char map[][] = new char[20][20];
	char trap = 'T';
	char coin = 'C';
	char wall = '=';
	char exit = 'E';
	char player = 'P';
	char floor = '.';
	char goal = 'G';
	
	void printmap(){
		for(int i = 0 ; i < 20 ; i++){
			for(int j = 0 ;j < 20 ; j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	void generate(){
		map[0][0] =player;
		map[20][20] = goal;
		
	}
}
