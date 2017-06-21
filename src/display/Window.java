package display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JFrame;

import audio.Audio;
import instruments.GuitarBoard;
import song_list.QuanSong;
import song_list.Song;

public class Window extends JFrame{

	// 1st element - note is pressed, to check its location
	private static final boolean[] guitar_keys = {false,  false, false, false, false, false};
	private static int boardWidth = 1450, boardHeight = 800;
	private static ArrayList<Song> songList;
	
	public Window () {
		songList = new ArrayList<>();
		addSongs();
		JFrame frame = new JFrame("Guitar Hero");				// frame, has a title of Guitar Hero
		GuitarBoard guitar = new GuitarBoard();					// Set up GamePanel (class that we created)
		// Audio audio = new Audio();
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
					guitar_keys[0] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					guitar_keys[1] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					guitar_keys[2] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_F) {
					guitar_keys[3] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_G) {
					guitar_keys[4] = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					guitar_keys[5] = true;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_A) {
					guitar_keys[0] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					guitar_keys[1] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					guitar_keys[2] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_F) {
					guitar_keys[3] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_G) {
					guitar_keys[4] = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					guitar_keys[5] = false;
				}
			}
		});
		
		frame.add(guitar);
		// frame.add(audio);
		/**
		 * Used to execute code after a given delay
		 * The attribute is corePoolSize - the number of threads to keep in 
		 * the pool, even if they are idle
		 */
		
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

		// Method to execute, initial delay, subsequent delay, time unit
		executor.scheduleAtFixedRate(new RepaintBoard(guitar), 0L, 1L, TimeUnit.NANOSECONDS);
		// executor.scheduleAtFixedRate(new PlayAudio(audio), 0L, 1L, TimeUnit.NANOSECONDS);
		frame.setVisible(true);
	}
	
	private void addSongs() {
		songList.add(new QuanSong());
	}
	
	public static ArrayList<Song> getSongList() {
		return songList;
	}
		
	public static int getBoardWidth() {
		return boardWidth;
	}
	
	public static int getBoardHeight() {
		return boardHeight;
	}
	
	public static boolean[] getGuitarKeyList() {
		return guitar_keys;
	}
	
	/**
	 * 
	 * @param args
	 * This is where our code is run
	 */
	public static void main(String[] args) {
		new Window();
	}
	
}
/*
class PlayAudio implements Runnable {
	Audio audioPlayer;

	public PlayAudio(Audio audioPlayer) {
		this.audioPlayer = audioPlayer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
*/

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