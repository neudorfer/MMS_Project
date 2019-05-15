
public class TestGameObject extends GameObject {

	public TestGameObject(int x, int y, int width, int heigth, String imagePath, int speedx, int speedy) {
		super(x, y, width, heigth, imagePath, speedx, speedy);
		
	}
	
	public void update() {
		//simple left/right-movement
		setX(getX()+getSpeedx());
		setY(getY()+getSpeedy());
		
		if (getX()<10) {
			setSpeedx(Math.abs(getSpeedx()));
		}
		if (getX()>550) {
			setSpeedx(-Math.abs(getSpeedx()));
		}
	
	}
	
}
