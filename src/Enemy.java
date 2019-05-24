

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
		return shooting;
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setShooting(boolean status) {
		shooting = status;
	}
	
	public void setAlive() {
		alive = false;
	}
	
	public void update() {
		x += speedx;
		y += speedy;
	}

	public void changeDirection() {
		speedx = speedx *-1;
		this.y += 5;
	}

}
