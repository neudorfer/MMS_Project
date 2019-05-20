import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Ship extends GameObject {

	public final int START_POS_X = 200;
	public int START_POS_Y = 500;
	
	private boolean isShooting;
	private boolean isAlive;
	
	public Ship(int x, int y, int width, int heigth, String imagePath, int speedx, int speedy) {
		super(x, y, width, heigth, imagePath, speedx, speedy);
		this.isShooting = false;
		this.isAlive = true;
	}
	
	public Ship getShip() {
		return this;
	}
	
	public boolean isShooting() {
		return isShooting;
	}
	
	// setDead method to set isAlive to false after Player got hit
	public void setDead() {
		isAlive = false;
	}
	
	public boolean alive() {
		return isAlive;
	}
	
	// setShooting method to set isShooting to false after Shot creation
	public void setShooting(boolean shooting) {
		isShooting = shooting;
	}
	
	public void update() {
		// increment position by speed on each update
		x += speedx;
		
		// check to make sure we are not going out of bounds
		if(x <= 0) {
			x = 0;
		}
		
		if(x >= 600 - 4 * getWidth()) {
			x = 600 - 4 * getWidth();
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			speedx = 5;
		}
		
		if(key == KeyEvent.VK_LEFT) {
			speedx = -5;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			speedx = 0;
		}
		
		if(key == KeyEvent.VK_LEFT) {
			speedx = 0;
		}
		// when the spacebar is released we want to shoot
		if(key == KeyEvent.VK_SPACE) {
			System.out.println("peng");
			isShooting = true;
		}
	}	
}
