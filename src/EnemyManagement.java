
import java.util.*;

public class EnemyManagement {
	private ArrayList<Enemy> enemys1;
	private ArrayList<Enemy> enemys2;
	private ArrayList<Enemy> enemys3;
	private int counterShoot=0;
	private int COUNT_ENEMY_PER_ROW = 5;
	
	public EnemyManagement() {
		enemys1 = new ArrayList<Enemy>(); //Oberste Reihe
		enemys2 = new ArrayList<Enemy>(); //Mittlere Reihe
		enemys3 = new ArrayList<Enemy>(); //Untere Reihe
		int width=17;
		int heigth=17;
		String imagePath = "/enemy.png";
		int speedx=1;
		int speedy=0;
		Enemy newEnemy;
		
		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) {
			newEnemy = new Enemy(5+i*20, 0, width, heigth, imagePath, speedx, speedy);
			enemys1.add(newEnemy);
		}
		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { 
			newEnemy = new Enemy(5+i*20, 20, width, heigth, imagePath, speedx, speedy);
			enemys2.add(newEnemy);
		}
		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { 
			newEnemy = new Enemy(5+i*20, 40, width, heigth, imagePath, speedx, speedy);
			enemys3.add(newEnemy);
		}
	}
	
	public void update() {

		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { //enemy bewegen
			enemys1.get(i).update();
			enemys3.get(i).update();
			enemys3.get(i).update();
		}
		
		counterShoot++;
		
		if(counterShoot == 75) {
			for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { //um die abfrage zu verringern alle enemy shooting false setzen
				enemys1.get(i).setShooting(false);
				enemys3.get(i).setShooting(false);
				enemys3.get(i).setShooting(false);
			}
			//neuen schießenden enemy setzten lebt NR n in der ersten Reihe dann er sonst reihe 2 oder reihe 1
			Random rand = new Random();
			int n = rand.nextInt(COUNT_ENEMY_PER_ROW);
			if(enemys3.get(n).alive) {
				enemys3.get(n).setShooting(true);
			} else if (enemys2.get(n).alive) {
				enemys2.get(n).setShooting(true);
			} else {
				enemys1.get(n).setShooting(true);
			}
			counterShoot=0;
		}
	}
}
