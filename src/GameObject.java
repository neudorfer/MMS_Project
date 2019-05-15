import java.awt.Image;

public class GameObject {

	private int x;
	private int y;
	private int width;
	private int heigth;
	private String imagePath;
	private int speedx;
	private int speedy;
	private Image image;

	public GameObject(int x, int y, int width, int heigth, String imagePath, int speedx, int speedy) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.heigth = heigth;
		this.imagePath=imagePath;
		image = ImageLoader.loadImage(imagePath);
		this.speedx = speedx;
		this.speedy = speedy;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeigth() {
		return heigth;
	}


	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}


	public String getImagePath() {
		return imagePath;
	}

	public int getSpeedx() {
		return speedx;
	}


	public void setSpeedx(int speedx) {
		this.speedx = speedx;
	}


	public int getSpeedy() {
		return speedy;
	}


	public void setSpeedy(int speedy) {
		this.speedy = speedy;
	}
	
	public void update() {
		
	}

	public Image getImage() {
		return image;
	}
	
}
