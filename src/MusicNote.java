import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class MusicNote {

	// private instant data
	private Color color;
	private double noteLength;
	private String strNote;
	private Ellipse2D.Double ellipse;
	private double x, y;
	private int width = 300;
	
	// default constructor to randomize notes
	public MusicNote() {
		ArrayList<Color> colorList = new ArrayList<>(5);
		colorList.add(Color.RED);
		colorList.add(Color.YELLOW);
		colorList.add(Color.GREEN);
		colorList.add(Color.BLUE);
		colorList.add(Color.ORANGE);
		Color rand = colorList.get((int)(Math.random()*5));
		this.color = rand;
		if(color.equals(Color.RED)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.noteLength = 0.25;
		this.strNote = "A";
	}
	
	public MusicNote(Color color, double noteLength, String strNote) {
		this.color = color;
		if(color.equals(Color.RED)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = GamePanel.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.noteLength = noteLength;
		this.strNote = strNote;
	}

	public Color getNoteColor() {
		return color;
	}
	
	public double getNoteLength() {
		return noteLength;
	}
	
	public void render(Graphics2D g){
		g.setColor(color);
		Stroke stroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		g.setStroke(stroke);
		g.fill(ellipse);
		
		// ((Graphics2D)note.getEllipse()).translate(note.getX(), note.getY()+2);
	}
	
	public String strNote() {
		return strNote;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Ellipse2D.Double getEllipse() {
		return ellipse;
	}
	
}

/**
 *
 * Note - color, length, where it will display (time/speed)
 * separate Thread - time? (maybe)
 * ArrayList<Note, Chords>
 * 
 * Sound - we don't care now
 * 
 * Score system
 * 
 * Input to computer 
 * 
 */
