

public class Wall extends GameObject {

	private int lifes;
	
	public Wall(int x, int y, int width, int heigth, String imagePath, int lifes) {
		super(x, y, width, heigth, imagePath, 0, 0);
		this.lifes = lifes;
	}
	public int getLifes() {
		return lifes;
	}
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	
}
