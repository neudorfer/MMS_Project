

public class Enemy extends GameObject {
	
	boolean alive;
	boolean shooting;

	public Enemy(int x, int y, int width, int heigth, String imagePath, int speedx, int speedy) {
		super(x, y, width, heigth, imagePath, speedx, speedy);
		this.alive = true;
		this.shooting = false;
	}
	
	public Enemy getEnemy() {
		return this;
	}
	
	public boolean getShooting() {
		return shooing;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public boolean setShooting(boolean status) {
		shooting = status;
	}
	
	public boolean setAlive() {
		alive = false;
	}
	
	public void update() {
		x += speedx;
		y += speedy;
	}
}
