


public class EnemyManagement {
	private ArrayList<Enemy> enemys;
	
	public EnemyManagement() {
		enemys = new ArrayList<Enemy>();
		int x=1;
		int y=0;
		int width=0;
		int heigth=0;
		String imagePath = "/enemy.png";
		int speedx=0;
		int speedy=0;
		Enemy newEnemy = Enemy(x, y, width, heigth, imagePath, speedx, speedy);
		
		for (int i = 0; i<15 ; i++) {
			enemys.Add(newEnemy);
		}
	}
	
	public void update(Enemy enemy) {
		//Set last shooting enemy false
		for(Enemy enemy : a.getEnemies()) {
			if (enemy.getShooting == true) {
				enemy.setShooting(false);			
			}
		}
		//Set new shooting enemy
		Random rand = new Random();
		int n = rand.nextInt(15);
		enemys[n].setShooting(true);
	}
}
