import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int boardWidth = 1450, boardHeight = 800;
	private Guitar guitar;
	private ArrayList<Song> songList;
	private ScoreBoard board;

	
	public GamePanel() {
		this.setPreferredSize(new Dimension(boardWidth, boardHeight));
		this.setFocusable(true);
		guitar = new Guitar();
		songList = new ArrayList<>();
		board = new ScoreBoard();
		addSongs();
	}
	
	public static int getBoardWidth()  { return boardWidth;  }
	public static int getBoardHeight() { return boardHeight; } 
	
	public void addSongs() {
		songList.add(new NewSong());
		songList.add(new QuanSong());
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D settings = (Graphics2D)g; 
		try {
			Image bg = ImageIO.read(new File("crowd.jpg"));
			Image img = bg.getScaledInstance(boardWidth, boardHeight, Image.SCALE_DEFAULT);
			settings.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		guitar.render(settings);
		songList.get(1).render(settings);
		board.render(settings);
	}
}