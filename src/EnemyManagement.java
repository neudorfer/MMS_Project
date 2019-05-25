
import java.util.*;
import java.util.stream.Stream;

public class EnemyManagement {
	private ArrayList<Enemy> enemys1;
	private ArrayList<Enemy> enemys2;
	private ArrayList<Enemy> enemys3;
	private int counterShoot=0;
	private int COUNT_ENEMY_PER_ROW = 5;
	private ArrayList<Enemy> alive3 ;
	private ArrayList<Enemy> alive2;
	private ArrayList<Enemy> alive1; 

	public EnemyManagement() {
		enemys1 = new ArrayList<Enemy>(); //Oberste Reihe
		enemys2 = new ArrayList<Enemy>(); //Mittlere Reihe
		enemys3 = new ArrayList<Enemy>(); //Untere Reihe
		alive3 =  new ArrayList<Enemy>();
		alive2 =  new ArrayList<Enemy>();
		alive1 =  new ArrayList<Enemy>();

		int width=40;
		int heigth=37;
		String imagePath = "/enemy.png";
		int speedx=1;
		int speedy=0;
		Enemy newEnemy;

		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) {
			newEnemy = new Enemy(5+i*40, 0, width, heigth, imagePath, speedx, speedy);
			enemys1.add(newEnemy);
		}
		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { 
			newEnemy = new Enemy(5+i*40, 50, width, heigth, imagePath, speedx, speedy);
			enemys2.add(newEnemy);
		}
		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { 
			newEnemy = new Enemy(5+i*40, 50, width, heigth, imagePath, speedx, speedy);
			enemys3.add(newEnemy);
		}
	}



	public void update() {

		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { // Richtung ändern

			if(enemys1.get(i).getY() < 25 || enemys2.get(i).getY() < 25 ||enemys3.get(i).getY() < 25 || enemys1.get(i).getY()>575 || enemys2.get(i).getY()>575 ||enemys3.get(i).getY() >575 ) {

				for (int j = 0; i<COUNT_ENEMY_PER_ROW ; j++) {
					enemys1.get(j).changeDirection();
					enemys2.get(j).changeDirection();
					enemys3.get(j).changeDirection();
				} 
				break;

			}
		}

		for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { //enemy bewegen

			enemys1.get(i).update();
			enemys3.get(i).update();
			enemys3.get(i).update();
		}

		counterShoot++;
        
		alive3.clear();
		alive2.clear();
		alive1.clear();
		
		Stream<Enemy> stream3 = enemys3.stream();
		stream3.filter(x -> x.getAlive());
		stream3.forEach(x -> alive3.add(x));

		Stream<Enemy> stream2 = enemys3.stream();
		stream2.filter(x -> x.getAlive());
		stream2.forEach(x -> alive2.add(x));

		Stream<Enemy> stream1 = enemys3.stream();
		stream1.filter(x -> x.getAlive());
		stream1.forEach(x -> alive1.add(x));
		
		
		
		if(counterShoot == 75) {
			//			for (int i = 0; i<COUNT_ENEMY_PER_ROW ; i++) { //um die abfrage zu verringern alle enemy shooting false setzen, nicht nötig, da ich den schießenenden gegner nach den schuss auf false setze
			//				enemys1.get(i).setShooting(false);
			//				enemys3.get(i).setShooting(false);
			//				enemys3.get(i).setShooting(false);
			//			}

			//neuen schieÃŸenden enemy setzten lebt NR n in der ersten Reihe dann er sonst reihe 2 oder reihe 1

			Random rand = new Random();

			if(alive3.size() > 0) {
				int n = rand.nextInt(alive3.size());
				alive3.get(n).setShooting(true);
			} else
				if(alive2.size() > 0) {
					int n = rand.nextInt(alive2.size());
					alive2.get(n).setShooting(true);
				}
				else
					if(alive1.size() > 0) {
						int n = rand.nextInt(alive1.size());
						alive1.get(n).setShooting(true);
					}

			counterShoot=0;
		}
	}


	public ArrayList<Enemy> getEnemys1() {
		return enemys1;
	}



	public void setEnemys1(ArrayList<Enemy> enemys1) {
		this.enemys1 = enemys1;
	}



	public ArrayList<Enemy> getEnemys2() {
		return enemys2;
	}



	public void setEnemys2(ArrayList<Enemy> enemys2) {
		this.enemys2 = enemys2;
	}



	public ArrayList<Enemy> getEnemys3() {
		return enemys3;
	}



	public void setEnemys3(ArrayList<Enemy> enemys3) {
		this.enemys3 = enemys3;
	}



	public ArrayList<Enemy> getAlive3() {
		return alive3;
	}



	public void setAlive3(ArrayList<Enemy> alive3) {
		this.alive3 = alive3;
	}



	public ArrayList<Enemy> getAlive2() {
		return alive2;
	}



	public void setAlive2(ArrayList<Enemy> alive2) {
		this.alive2 = alive2;
	}



	public ArrayList<Enemy> getAlive1() {
		return alive1;
	}



	public void setAlive1(ArrayList<Enemy> alive1) {
		this.alive1 = alive1;
	}


}
