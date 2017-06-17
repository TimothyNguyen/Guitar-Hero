package objects;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Ring {

	private int x, y;
	private Ellipse2D.Double ellipse;
	private Color color; 
	
	public Ring(int x, Color color) {
		this.x = x;
		this.y = 680;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.color = color;
	}

	public Color getColor() { return color; }
}