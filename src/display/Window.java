package display;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;

import objects.GuitarBoard;

public class Window extends JFrame{

	private static final boolean[] theKeys = {false, false, false, false, false, false};
	private static int boardWidth = 1450, boardHeight = 800;
	
	public Window () {
		JFrame frame = new JFrame("Guitar Hero");				// frame, has a title of Guitar Hero
		GuitarBoard guitar = new GuitarBoard();					// Set up GamePanel (class that we created)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(boardWidth, boardHeight);
		// Key events
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					theKeys[0] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					theKeys[1] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					theKeys[2] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_F) {
					theKeys[3] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_G) {
					theKeys[4] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					theKeys[5] = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_A) {
					theKeys[0] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					theKeys[1] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					theKeys[2] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_F) {
					theKeys[3] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_G) {
					theKeys[4] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					theKeys[5] = false;
				}
			}
		});
		
		frame.add(guitar, BorderLayout.CENTER);
		
		/**
		 * Used to execute code after a given delay
		 * The attribute is corePoolSize - the number of threads to keep in 
		 * the pool, even if they are idle
		 */
		
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

		// Method to execute, initial delay, subsequent delay, time unit
		executor.scheduleAtFixedRate(new RepaintBoard(guitar), 0L, 1L, TimeUnit.NANOSECONDS);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window();
	}
		
	public static int getBoardWidth() {
		return boardWidth;
	}
	
	public static int getBoardHeight() {
		return boardHeight;
	}
	
	public static boolean[] getList() {
		return theKeys;
	}
}

class RepaintBoard implements Runnable {
	JComponent thePanel;

	public RepaintBoard(JComponent thePanel){
		this.thePanel = thePanel;
	}

	@Override
	public void run() {
		thePanel.repaint();
	}
}