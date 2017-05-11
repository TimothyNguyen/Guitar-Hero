import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class ScoreBoard{
	private int xCoor, yCoor;
	private int width, height;
	private Rectangle scoreBoard;
	private Color color;
	
	public ScoreBoard(){
		this.width = 100;
		this.height = 100;
		this.xCoor = GamePanel.getBoardWidth() - GamePanel.getBoardWidth()/4;
		this.yCoor= GamePanel.getBoardHeight() - GamePanel.getBoardHeight()/4;
		this.color = new Color(153, 76, 0);
		
		scoreBoard = new Rectangle(xCoor, yCoor, width, height);
	}
	
	public void render(Graphics2D g){
		g.setColor(color);
		g.fill(scoreBoard);
		
	}
}
