import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Window {

	private static final boolean[] theKeys = {false, false, false, false, false, false};
	
	public static void main(String[] args) {
	
		JFrame frame = new JFrame("Guitar Hero");				// frame, has a title of Guitar Hero
		GamePanel panel = new GamePanel();						// Set up GamePanel (class that we created)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setFocusable(true); // get the keylistener to work
		frame.setResizable(true);
		frame.pack();
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
		/**
		 * Used to execute code after a given delay
		 * The attribute is corePoolSize - the number of threads to keep in 
		 * the pool, even if they are idle
		 */
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

		// Method to execute, initial delay, subsequent delay, time unit
		executor.scheduleAtFixedRate(new RepaintBoard(panel), 0L, 1L, TimeUnit.NANOSECONDS);
		frame.setVisible(true);
	}
		
	public static boolean[] getList() {
		return theKeys;
	}
}

class RepaintBoard implements Runnable {
	GamePanel thePanel;

	public RepaintBoard(GamePanel thePanel){
		this.thePanel = thePanel;
	}

	@Override
	public void run() {
		thePanel.repaint();
	}
}
