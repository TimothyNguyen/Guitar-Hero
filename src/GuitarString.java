import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GuitarString {
	
	private int x, y;
	private Rectangle string;
	private Color color;
	
	public GuitarString(int x, Color color) {
		this.x = x;
		this.y = 50;
		string = new Rectangle(x, y, 15, 700);
		this.color = color;
	}
	
	public Color getColor() { return color; }
	
	public void render(Graphics2D g){
		g.setColor(color);
		g.fill(string);
	}
	
}
