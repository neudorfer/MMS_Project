

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game  {
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	final GamePanel gp;
	
	private ShotManagement shotManagement;
	private EnemyManagement enemyManagement;
	private Ship ship;

	public Game() {
		gp = new GamePanel(WIDTH,HEIGHT, this);
		initComponentes();
	}

	private void initShip() {
		ship = new Ship(200,500,25,25,"images/ship.png",0,0);
	}
	
	private void initComponentes() {
		
		JFrame frame = new JFrame("Space Invaders");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		
		// START-/STOP-Button
		final JButton startButton = new JButton("Start");
		final JButton stopButton = new JButton("Stop");
		
		// ActionListener for START-Button
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
//				// Initialize Test-level
				initTestLevel();
				
				// Initialize ShotManagement
				setShotManagement(new ShotManagement());
				
				//Start Game-Loop
				GamePanel.setRunning(true);
				runGameLoop(gp);
				
				//Set START-STOP-Button to correct setup
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
		});		
			
		// ActionListener for STOP-Button
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePanel.setRunning(false);
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		});		
		
		// Default-Setup from START-/STOP-Button
		startButton.setEnabled(true);
		stopButton.setEnabled(false);
		
		// Add START-/STOP-Buttons to ButtonPanel
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		// Add ButtonPanel + GamePanel to JFrame
		frame.add(gp);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.addKeyListener(new ShipListener());
		frame.pack();
		
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	private void runGameLoop (final GamePanel gp) {
		
		// Start gameloop in new Thread
		Thread loop = new Thread(new Runnable() {
			@Override
			public void run() {
				gp.gameLoop();
			}
		});
		loop.start();
	}
	
	//Initialization of TestLevel
	private void initTestLevel() {
		gp.clearGameObjects();
		
		initShip();
		TestGameObject testObject1 = new TestGameObject(50,50,27,14,"/images/testImage.png",1,0);
		TestGameObject testObject2 = new TestGameObject(50,100,27,14,"/images/testImage.png",2,0);
		TestGameObject testObject3 = new TestGameObject(50,150,27,14,"/images/testImage.png",3,0);
		TestGameObject testObject4 = new TestGameObject(50,200,27,14,"/images/testImage.png",4,0);
		TestGameObject testObject5 = new TestGameObject(50,250,27,14,"/images/testImage.png",5,0);
		TestGameObject testObject6 = new TestGameObject(50,300,27,14,"/images/testImage.png",6,0);
		TestGameObject testObject7 = new TestGameObject(50,320,27,14,"/images/testImage.png",7,0);
		TestGameObject testObject8 = new TestGameObject(50,350,27,14,"/images/testImage.png",8,0);
		TestGameObject testObject9 = new TestGameObject(50,370,27,14,"/images/testImage.png",9,0);
		TestGameObject testObject0 = new TestGameObject(50,400,27,14,"/images/testImage.png",10,0);
		
		gp.addGameObject(testObject1);
		gp.addGameObject(testObject2);
		gp.addGameObject(testObject3);
		gp.addGameObject(testObject4);
		gp.addGameObject(testObject5);
		gp.addGameObject(testObject6);
		gp.addGameObject(testObject7);
		gp.addGameObject(testObject8);
		gp.addGameObject(testObject9);
		gp.addGameObject(testObject0);
		gp.addGameObject(ship);
	}

	public ShotManagement getShotManagement() {
		return shotManagement;
	}
	
	public void setShotManagement(ShotManagement shotManagement) {
		this.shotManagement = shotManagement;
	}

	public EnemyManagement getEnemyManagement() {
		return enemyManagement;
	}

	public void setEnemyManagement(EnemyManagement enemyManagement) {
		this.enemyManagement = enemyManagement;
	}
	
	public ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> all = new ArrayList<Enemy>();
		all.addAll(enemyManagement.getEnemys1());
		all.addAll(enemyManagement.getEnemys2());
		all.addAll(enemyManagement.getEnemys3());
		return all;
	
	}
	public ArrayList<Enemy> getEnemiesAlive() {
		ArrayList<Enemy> all = new ArrayList<Enemy>();
		all.addAll(enemyManagement.getAlive1());
		all.addAll(enemyManagement.getAlive2());
		all.addAll(enemyManagement.getAlive3());
		return all;
	
	}
	public Ship getShip() {
		//TODO: return the actual Ship
		return ship;
	}
	
	// return the width of the GamePanel
	public int getWidth() {
		return WIDTH;
	}
	
	// KeyListener for Ship actions like movement and shooting
	private class ShipListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			ship.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			ship.keyReleased(e);
		}
		
	}
}
