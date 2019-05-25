
import java.util.ArrayList;



public class ShotManagement {

	private ArrayList<GameObject> playerShots;
	private ArrayList<GameObject> enemyShots;
	private ArrayList<Explosion> explosions;
	private ArrayList<Wall> walls;



	public void update(Game a) {


		for(GameObject shot : playerShots) {
			shot.setX(shot.getX()+shot.getSpeedx());
			shot.setY(shot.getY()+shot.getSpeedy());

			if(shot.getX() < 0) {
				playerShots.remove(shot);
			}



			// look for enemy collision

			for(Enemy enemy : a.getEnemies()) {
				if (shot.getX() < enemy.getX() + enemy.getWidth() &&
						shot.getX() + shot.getWidth() > enemy.getX() &&
						shot.getY() < enemy.getY() + enemy.getHeigth() &&
						shot.getY() + shot.getHeigth() > enemy.getY())
				{
					enemy.setAlive();
					playerShots.remove(shot);
					explosions.add(new Explosion(enemy.getX(),enemy.getY(),17,17,"/explosion.gif"));

				}

			}
			// check for wall collisions

			for(Wall wall : walls) {
				if (shot.getX() < wall.getX() + wall.getWidth() &&
						shot.getX() + shot.getWidth() > wall.getX() &&
						shot.getY() < wall.getY() + wall.getHeigth() &&
						shot.getY() + shot.getHeigth() > wall.getY())
				{
					playerShots.remove(shot);
					wall.setLifes(wall.getLifes()-1);
					if(wall.getLifes() < 1) {
						walls.remove(wall);
					}				
				}


			}


		}

		for(GameObject shot : enemyShots) {
			shot.setX(shot.getX()+shot.getSpeedx());
			shot.setY(shot.getY()+shot.getSpeedy());

			if(shot.getX() > 600) {
				enemyShots.remove(shot);
			}


			// look for playership collision


			if (shot.getX() < a.getShip().getX() + a.getShip().getWidth() &&
					shot.getX() + shot.getWidth() > a.getShip().getX() &&
					shot.getY() < a.getShip().getY() + a.getShip().getHeigth() &&
					shot.getY() + shot.getHeigth() > a.getShip().getY())
			{

				enemyShots.remove(shot);

				explosions.add(new Explosion(a.getShip().getX() ,a.getShip().getY(),17,17,"/explosion.gif"));

				explosions.add(new Explosion(a.getShip().getX() ,a.getShip().getY(),17,17,"/explosion.png"));


			}


			// check for wall collisions

			for(Wall wall : walls) {
				if (shot.getX() < wall.getX() + wall.getWidth() &&
						shot.getX() + shot.getWidth() > wall.getX() &&
						shot.getY() < wall.getX() + wall.getHeigth() &&
						shot.getY() + shot.getHeigth() > wall.getX())
				{
					enemyShots.remove(shot);
					wall.setLifes(wall.getLifes()-1);
					if(wall.getLifes() < 1) {
						walls.remove(wall);
					}

				}

			}


		}


		// create new playershots

		if(a.getShip().isShooting() == true) {
			GameObject newShot = new Shots(a.getShip().getX()+20,a.getShip().getY(),7,47,"/playershot.png",0,10 );
			playerShots.add(newShot);
			a.getShip().setShooting(false);

		}

		// create new Enemyshots

		for(Enemy enemy : a.getEnemiesAlive()) {
			if(enemy.getShooting() == true) {
				GameObject newShot = new Shots(enemy.getX()+20,enemy.getY()+20,17,17,"/enemyshot.png",0,10 );
				enemyShots.add(newShot);
				enemy.setShooting(false);
			}


		}





	}


	public void start() { // sets the walls

		walls.add(new Wall(50,50,100,30,"/wall.png", 3));

	}


}
