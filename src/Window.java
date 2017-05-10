import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Window {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Guitar Hero");
		GamePanel panel = new GamePanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setResizable(false);
		frame.pack();
        // Used to execute code after a given delay
        // The attribute is corePoolSize - the number of threads to keep in 
        // the pool, even if they are idle
        
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
		
        // Method to execute, initial delay, subsequent delay, time unit
        
		executor.scheduleAtFixedRate(new RepaintBoard(panel), 0L, 20L, TimeUnit.MILLISECONDS);
		frame.setVisible(true);
	}
	
}

class RepaintBoard implements Runnable {
	
	GamePanel thePanel;
	
	public RepaintBoard(GamePanel thePanel){
		this.thePanel = thePanel;
	}

	@Override
	public void run() {
		
		// Redraws the game board
		thePanel.repaint();
		
	}
	
}
