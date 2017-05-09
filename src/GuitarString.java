import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GuitarString {
	
	private int x, y;
	private Rectangle string;
	private Color color;
	
	public GuitarString(int x, Color color) {
		this.setX(x);
		this.y = 25;
		string = new Rectangle(x, y-5, 15, 735);
		this.color = color;
	}
	
	public Color getColor() { return color; }
	
	public void render(Graphics2D g){
		g.setColor(color);
		g.fill(string);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
