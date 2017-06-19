package instruments.guitar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;

import display.Window;

public class MusicNote {

	// private instant data
	private Color color;				// The color of the music note
	private double noteLength;			// The length of the music note 
	private String strNote;				// the name of the note
	private Ellipse2D.Double ellipse;	// creating the shape of the music note
	private double x, y;				// its x and y value
	private int width = 300;			// the width of the note
	private int noteValue, velocity;
	private double duration;
	private String[] noteList = {
			"C2", "C#2", "D2", "D#2", "E2", "F2", "F#2", "G2", "G#2", "A2", "A#2", "B2",
			"C3", "C#3", "D3", "D#3", "E3", "F3", "F#3", "G3", "G#3", "A3", "A#3", "B3",
			"C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4",
			"C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5"
	};

	public MusicNote() {
		Color[] color = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.ORANGE};
		this.color = color[((int)(Math.random()*5))];
		if(color.equals(Color.RED)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		this.duration = 0.5;
		this.velocity = 100;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.noteLength = 0.25;
	}

	public MusicNote(String strNote, Color color) {
		this.color = color;
		if(color.equals(Color.RED)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 247;
		}
		this.strNote = strNote;
		this.y = 50;
		this.noteLength = 0.5;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.strNote = strNote;
		this.duration = 0.5;
		this.velocity = 100;
		this.noteValue = getNoteValue(strNote);
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
		this.color = color;
		if(color.equals(Color.RED)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		this.noteLength = noteLength;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.strNote = strNote;
		this.duration = 0.5;
		this.velocity = 100;
		this.noteValue = getNoteValue(strNote);
	}

	public MusicNote(Color color, double noteLength, String strNote, double duration) {
		this.color = color;
		if(color.equals(Color.RED)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		this.noteLength = noteLength;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.strNote = strNote;
		this.duration = duration;
		this.velocity = 100;
		this.noteValue = getNoteValue(strNote);
	}

	public MusicNote(Color color, double noteLength, String strNote, double duration, int velocity) {
		this.color = color;
		if(color.equals(Color.RED)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 7;
		} else if(color.equals(Color.YELLOW)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 67;
		} else if(color.equals(Color.GREEN)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 127;
		} else if(color.equals(Color.BLUE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 187;
		} else if(color.equals(Color.ORANGE)) {
			this.x = Window.getBoardWidth()/2 - (width/2) + 247;
		}
		this.y = 50;
		this.noteLength = noteLength;
		ellipse = new Ellipse2D.Double(x, y, 45, 40);
		this.strNote = strNote;
		this.duration = duration;
		this.velocity = velocity;
		this.noteValue = getNoteValue(strNote);
	}


	public int getNoteValue() {
		return noteValue;
	}

	// Returns the length of the note
	public double getNoteLength() {
		return noteLength;
	}

	public String getStringNote() {
		return strNote;
	}

	public double getDuration() {
		return duration;
	}

	public double getVelocity() {
		return velocity;
	}

	private int getNoteValue(String str) {
		int val = 36;
		for(int i = 0; i < noteList.length; i++) {
			if(noteList[i].equals(str)) return val;
			val++;
		}
		return 60;
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

	// Returns the color of the music note
	public Color getNoteColor() {
		return color;
	}

	public Ellipse2D.Double getEllipse() {
		return ellipse;
	}	
	
}
