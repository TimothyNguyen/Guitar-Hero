import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	public void render(Graphics2D g){
		g.setColor(color);
		Stroke stroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		g.setStroke(stroke);
		// g.fill(ellipse);
		g.draw(ellipse);
	} 
	
	public void fillEllipse(Graphics2D g) {
		g.setColor(color);
		// Stroke stroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		// g.setStroke(stroke);
		g.fill(ellipse);
		g.draw(ellipse);
	}
}
