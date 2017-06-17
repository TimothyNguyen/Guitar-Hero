package objects;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import display.GamePanel;

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
}