import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MusicNote {

	// private instant data
	private Color color;				// The color of the music note
	private double noteLength;			// The length of the music note 
	private String strNote;				// the name of the note
	private Ellipse2D.Double ellipse;	// creating the shape of the music note
	private double x, y;				// its x and y value
	private int width = 300;			// the width of the note
	private Integer numNote;
	private HashMap<String, Integer> noteList = new HashMap<>();
	/**
	 * This default constructor is used for QuanSong temporarily
	 * It randomizes the colors of the notes and the number of notes that appear on the screen at a given tempo/rate
	 * and sets the default parameters
	 */
	
	// TODO: Need to add more notes
	public void defaultNoteList() {
		noteList.put("C2", 36);
		noteList.put("C#2", 37);
		noteList.put("D2", 38);
		noteList.put("D#2", 39);
		noteList.put("E2", 40);
		noteList.put("F2", 41);
		noteList.put("F#2", 42);
		noteList.put("G2", 43);
		noteList.put("G#2", 44);
		noteList.put("A2", 45);
		noteList.put("A#2", 46);
		noteList.put("B2", 47);
		noteList.put("C3", 48);
		noteList.put("C#3", 49);
		noteList.put("D3", 50);
		noteList.put("D#3", 51);
		noteList.put("E3", 52);
		noteList.put("F3", 53);
		noteList.put("F#3", 54);
		noteList.put("G3", 55);
		noteList.put("G#3", 56);
		noteList.put("A3", 57);
		noteList.put("A#3", 58);
		noteList.put("B3", 59);
		noteList.put("C4", 60);
	}
	
	
	public MusicNote() {
		defaultNoteList();
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
		// numNote = noteList.get((int)(Math.random()*noteList.size()));
		Collection<Integer> noteValues = noteList.values();
		ArrayList<Integer> val = new ArrayList<>();
		for(Integer i : noteValues) {
			val.add(i);
		}
		numNote = val.get((int)(Math.random()*noteList.size()));
		// this.strNote = default_noteArr[(int)(Math.random()*default_noteArr.length)];
		System.out.println(numNote);
	}
	
	/**
	 * 
	 * @param color
	 * @param noteLength
	 * @param strNote
	 * 
	 * Sets these parameters for songs with a given rate and time
	 */
	
	public MusicNote(Color color, double noteLength, String strNote) {
		defaultNoteList();
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
		this.noteLength = noteLength;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		// TODO: Notelength stuff with extend note class
		this.strNote = strNote;
		// need to add key note
	}
	
	// Returns the color of the music note
	public Color getNoteColor() {
		return color;
	}
	
	// Returns the length of the note
	public double getNoteLength() {
		return noteLength;
	}
	
	public int getNoteNum() {
		return numNote;
	}
	 
	public int getColorNum() {
		if(color.equals(Color.RED)) {
			return 0;
		}else if(color.equals(Color.YELLOW)) {
			return 1;
		}else if(color.equals(Color.GREEN)) {
			return 2;
		}else if(color.equals(Color.BLUE)) {
			return 3;
		}
		return 4; 
	}
	
	public void render(Graphics2D g){
		g.setColor(color);
		Stroke stroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		g.setStroke(stroke);
		g.fill(ellipse);
	}
	
	public String strNote() {
		return strNote;
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
 * 
 */
