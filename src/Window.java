import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Window {

	private static boolean keyHeld = false;
	private static final ArrayList<Integer> keys = new ArrayList<>();
	private static final boolean[] theKeys = {false, false, false, false, false};
	
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
				// TODO Auto-generated method stub
				/*
				 keys.add(e.getKeyCode());
				 if(keys.size() >= 1) {
					 keyHeld = true;
					 System.out.println("Hello");
				 }
				 */
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
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				/*
				keys.remove(e.getKeyCode());
				if(keys.size() == 0) {
					keyHeld = false;
				}
				*/
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
			}

		});
		/**
		 * Used to execute code after a given delay
		 * The attribute is corePoolSize - the number of threads to keep in 
		 * the pool, even if they are idle
		 */
		// ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

		// Method to execute, initial delay, subsequent delay, time unit
		// executor.scheduleAtFixedRate(new RepaintBoard(panel), 0L, 1L, TimeUnit.NANOSECONDS);

		// int delay = 1000/60;

		Timer timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.repaint();
			}
			
		});
		timer.start();	
		frame.setVisible(true);
	}

	public static boolean[] getList() {
		return theKeys;
	}
	
/*
	public static boolean isKeyHeld() {
		return keyHeld;
	}
	
	public static ArrayList<Integer> getList() {
		return keys;
	}
	*/
	
	
	
	
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
