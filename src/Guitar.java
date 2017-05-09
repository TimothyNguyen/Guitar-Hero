import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Guitar {

	private int x, y;
	private int width, height;
	private Rectangle guitar_board;
	private Color color;
	private GuitarString str1;
	private GuitarString str2;
	private GuitarString str3;
	private GuitarString str4;
	private Bars bars;
	
	public Guitar() {
		this.width = 200;
		this.height = 700;
		this.x = GamePanel.getBoardWidth()/2 - (width/2);
		this.y = GamePanel.getBoardHeight()/2 - (height/2);
		this.color = new Color(153, 76, 0);
		guitar_board = new Rectangle(x, y, width, height);
		str1 = new GuitarString(x + 20, Color.RED);
		str2 = new GuitarString(x + 70, Color.YELLOW);
		str3 = new GuitarString(x + 120, Color.GREEN);
		str4 = new GuitarString(x + 170, Color.BLUE);
		bars = new Bars(width, height);
	}
	
	public int getGuitarX(){
		return x;
	}
	
	public int getGuitarY() {
		return y;
	}
	
	public int getGuitarWidth() {
		return width;
	}	
	
	public int getGuitarHeight() {
		return height;
	}
	
	public void render(Graphics2D g){
		g.setColor(color);
		g.fill(guitar_board);
		str1.render(g);
		str2.render(g);
		str3.render(g);
		str4.render(g);
		bars.render(g);
	}
	
	
}
