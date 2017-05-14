import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Window {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Guitar Hero");
		GamePanel panel = new GamePanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setResizable(true);
		frame.pack();
		// Used to execute code after a given delay
		// The attribute is corePoolSize - the number of threads to keep in 
		// the pool, even if they are idle

		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

		// Method to execute, initial delay, subsequent delay, time unit
		executor.scheduleAtFixedRate(new RepaintBoard(panel), 0L, 1L, TimeUnit.NANOSECONDS);
		frame.setVisible(true);
	}

}


class RepaintBoard implements Runnable {
	final double beats_per_minute = 1000000000000.0;
	final double SKIP_TICKS = 1000 / beats_per_minute;
	GamePanel thePanel;

	public RepaintBoard(GamePanel thePanel){
		this.thePanel = thePanel;
	}

	@Override
	public void run() {
		double next_game_tick = System.currentTimeMillis();

		while (true) {
			while (System.currentTimeMillis() > next_game_tick) {

				// Redraws the game board
				thePanel.repaint();
				next_game_tick += SKIP_TICKS;

			}
		}
	}
}