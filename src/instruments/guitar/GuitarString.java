package instruments.guitar;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class GuitarString {
	
	private int x, y;
	private Rectangle2D.Double string;
	private Color color;
	
	public GuitarString(int x, Color color) {
		this.setX(x);
		this.y = 25;
		string = new Rectangle2D.Double(x, y-5, 12, 660);
		this.color = color;
	}
	
	public Color getColor() { return color; }

	public Rectangle2D.Double getString() {
		return string;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}