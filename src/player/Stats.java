package player;

public class Stats {
	int life = 3;
	int level = 1;
	int time = 25;
	boolean isPaused = false;
	boolean trapStepped = false;
	boolean coinStepped = false;
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public boolean getPaused() {
		return isPaused;
	}
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	public boolean isTrapStepped() {
		return trapStepped;
	}
	public void setTrapStepped(boolean trapStepped) {
		this.trapStepped = trapStepped;
	}
	public boolean isCoinStepped() {
		return coinStepped;
	}
	public void setCoinStepped(boolean coinStepped) {
		this.coinStepped = coinStepped;
	}
	
	

	
	
	
	
}
