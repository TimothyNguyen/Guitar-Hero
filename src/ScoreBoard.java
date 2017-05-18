
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class ScoreBoard{

	private int width, height;
	private Rectangle scoreBoard;

	public ScoreBoard(){
		this.width = 400;
		this.height = 50;
		
	
		scoreBoard = new Rectangle(75, 70, width, height);
		

	}
	
	public void render(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fill(scoreBoard);
		g.setColor(Color.BLUE);
		g.setFont(new Font("TimesRoman", Font.BOLD, 40));
		g.drawString("Score: ",55, 50); 
		
	}
}
