import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int boardWidth = 1450, boardHeight = 800;
	private Guitar guitar;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(boardWidth, boardHeight));
		this.setFocusable(true);
		guitar = new Guitar();
	}
	
	public static int getBoardWidth()  { return boardWidth;  }
	public static int getBoardHeight() { return boardHeight; } 
	
	
	public void paintComponent(Graphics g) {
		Graphics2D settings = (Graphics2D)g; 
		settings.setColor(Color.BLACK);
		settings.fillRect(0, 0, boardWidth, boardHeight);
		guitar.render(settings);
	}
	
	
	
}
