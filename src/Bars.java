import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class Bars {

	
	// Making the barlines
	private ArrayList<Line2D.Double> barLines;
	private Color color;
	private int width, height;
	private double x1, x2;
	private double speed = 100;
	
	public Bars(int width, int height) {
		barLines = new ArrayList<>();
		color = Color.DARK_GRAY;			// making the bars gray
		this.width = width;
		this.height = height;
		x1 = GamePanel.getBoardWidth()/2 - (width/2);
		x2 = GamePanel.getBoardWidth()/2 - (width/2) + width;
		for(int y = 50; y < height; y += 250) {
			barLines.add(new Line2D.Double(x1, y, x2, y));
		}
	}
	
	public Color getColor() { return color; }		// getting the color of the bars 
	
	public void render(Graphics2D g){
		g.setColor(color);
		Stroke stroke = new BasicStroke(8, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		g.setStroke(stroke);
		for(int i = 0; i < barLines.size(); i++) {
			g.draw(barLines.get(i));
		}
		// song.render(g);
		for(int i = 0; i < barLines.size(); i++) {
			double y1 = barLines.get(i).getY1();
			double y2 = barLines.get(i).getY2();
			barLines.get(i).setLine(x1, y1 + 13.5, x2, y2 + 13.5);
			if(y1 > height) {
				barLines.get(i).setLine(x1, 50, x2, 50);
			}
		}
	}
}
