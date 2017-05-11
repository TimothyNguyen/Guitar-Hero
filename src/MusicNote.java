import java.awt.Color;

public class MusicNote {

	private Color color;
	private double noteLength;
	
	public MusicNote(Color color, double noteLength) {
		this.color = color;
		this.noteLength = noteLength;
	}

	public Color getNoteColor() {
		return color;
	}
	
	public double getNoteLength() {
		return noteLength;
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
