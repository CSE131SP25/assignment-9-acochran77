package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int score = 0;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds()) { // Update this condition to check if snake is in bounds
			int dir = getKeypress();
			snake.changeDirection(dir);
			snake.move();
			if(snake.eatFood(food)) {
				score ++;
				food = new Food();
			}
			updateDrawing();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		}
		
		StdDraw.clear();
		StdDraw.setPenColor(Color.RED);
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.show();
		System.out.println("Game over!");
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.pause(50);;
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.textLeft(0.02, 0.98, "Score: " + score);
		StdDraw.show();
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
