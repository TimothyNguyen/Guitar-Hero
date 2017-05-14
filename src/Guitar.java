import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Guitar {

	private int x, y;
	private int width, height;
	private Rectangle guitar_board;
	private Rectangle guitarBorder;
	private Color color;
	private Color colorBorder;
	private GuitarString str1;
	private GuitarString str2;
	private GuitarString str3;
	private GuitarString str4;
	private GuitarString str5;
	private Bars bars;
	private Ring red;
	private Ring yellow;
	private Ring green;
	private Ring blue;
	private Ring orange;
	
	
	public Guitar() {
		this.width = 300;
		this.height = 750;
		this.x = GamePanel.getBoardWidth()/2 - (width/2);
		this.y = GamePanel.getBoardHeight()/2 - (height/2);
		this.color = new Color(153, 76, 0);
		this.colorBorder = new Color(102,51,0);
		guitar_board = new Rectangle(x, y, width, height);
		guitarBorder = new Rectangle(x-10, y, width+20, height);
		str1 = new GuitarString(x + 24, Color.RED);
		str2 = new GuitarString(x + 84, Color.YELLOW);
		str3 = new GuitarString(x + 144, Color.GREEN);
		str4 = new GuitarString(x + 204, Color.BLUE);
		str5 = new GuitarString(x + 264, Color.ORANGE);
		bars = new Bars(width, height);
		red = new Ring(x + 7, Color.RED);
		yellow = new Ring(x + 67, Color.YELLOW);
		green = new Ring(x + 127, Color.GREEN);
		blue = new Ring(x + 187, Color.BLUE);
		orange = new Ring(x + 247, Color.ORANGE);
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
		g.setColor(colorBorder);
		g.fill(guitarBorder);
		g.setColor(color);
		g.fill(guitar_board);

		red.render(g);
		yellow.render(g);
		green.render(g);
		blue.render(g);
		orange.render(g);
		str1.render(g);
		str2.render(g);
		str3.render(g);
		str4.render(g);
		str5.render(g);
		bars.render(g);
	}
}
