
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel{
	private int xCoor, yCoor;
	private int width, height;
	private Rectangle scoreBoard;
	private Color color;

	private JLabel title = new JLabel("SCORE");
	
	
	public ScoreBoard(){
		this.width = 275;
		this.height = 300;
		this.xCoor = GamePanel.getBoardWidth() - GamePanel.getBoardWidth()/3;
		this.yCoor= GamePanel.getBoardHeight() - 400;
		this.color = new Color(153, 76, 0);
		
		scoreBoard = new Rectangle(xCoor, yCoor, width, height);
		
		title.setBounds(xCoor, yCoor, 20, 20);
		title.setOpaque(true);
		add(title);

		
	}
	
	public void render(Graphics2D g){
		g.setColor(color);
		g.fill(scoreBoard);
		
		
	}
}
