import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static boolean running = false;

	final private int width, height;
	final private Game game;
	private ArrayList<GameObject> gameObjects = new ArrayList<>(); //not needed, just for test
	
	public GamePanel (int width, int height, Game game) {
		super(true);
		setIgnoreRepaint(true);
		this.width = width;
		this.height = height;
		this.game = game;
	}
	
	public static boolean isRunning() {
		return running;
	}

	public static void setRunning(boolean running) {
		GamePanel.running = running;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	public void addGameObject (GameObject g) {
		gameObjects.add(g);
	}
	
	public void clearGameObjects() {
		gameObjects.clear();
	}
	
	public void gameLoop() {
		//set game-updates per second -> a change has effect on the game's speed
		final double GAME_UPDATES_PER_SECOND = 60.0;
		final double NANOSECS_BETWEEN_UPDATES = 1000000000 / GAME_UPDATES_PER_SECOND; //in nano-seconds
		//set graphics frames per second
		final double FPS = 120.0;
		final double NANOSECS_NS_BETWEEN_RENDERS = 1000000000 / FPS; //in nano-seconds
		
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime = System.nanoTime();		
		
		while (isRunning()) {
			//if update-time has come ....
			if(System.nanoTime()-lastUpdateTime>NANOSECS_BETWEEN_UPDATES) {
				// ... UPDATE GAME
				updateGame();
				lastUpdateTime = System.nanoTime();
			}
			
			//if render-time has come ...
			if(System.nanoTime()-lastRenderTime>NANOSECS_NS_BETWEEN_RENDERS) {
				// ... RENDER GAME
				renderGame();
				lastRenderTime = System.nanoTime();
			}

		}
	}
	
	private void renderGame() {
		repaint();
	}
	
	private void updateGame() {
		updateGameObjects(); // not needed, just for test
	}
	
	private void updateGameObjects() {
		for (GameObject go : gameObjects) {
			go.update();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		drawBackground(g2d);
		drawGameObjectsToScreen(g2d);
	}
	
	private void drawBackground(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}	
	
	private void drawGameObjectsToScreen(Graphics2D g2d) {
		for (GameObject go : gameObjects) {
			g2d.drawImage(go.getImage(), (int)go.getX(), (int)go.getY(), null);
		}
	}
}
