import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private int boardWidth = 1450, boardHeight = 800;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(boardWidth, boardHeight));
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, boardWidth, boardHeight);
	}
	
	
	
}
