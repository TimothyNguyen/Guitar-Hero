import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Chord {

	private ArrayList<MusicNote> chord;
	private double time;
	
	public Chord(MusicNote note1, MusicNote note2, MusicNote note3, MusicNote note4, MusicNote note5, double time) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		chord.add(note3);
		chord.add(note4);
		chord.add(note5);
		this.time = time;
	}
	
	public Chord(MusicNote note1, MusicNote note2, MusicNote note3, MusicNote note4, double time) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		chord.add(note3);
		chord.add(note4);
		this.time = time;
	}
	
	public Chord(MusicNote note1, MusicNote note2, MusicNote note3, double time) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		chord.add(note3);
		this.time = time;
	}
	
	public Chord(MusicNote note1, MusicNote note2, double time) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		this.time = time;
	}
	
	public Chord(MusicNote note1, double time) {
		chord = new ArrayList<>();
		chord.add(note1);
		this.time = time;
	}
	
	public double getTimeToStart() {
		return time;
	}
	
	public double getY() {
		return chord.get(0).getY();
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < chord.size(); i++) {
			chord.get(i).render(g);
		}
		for(int i = 0; i < chord.size(); i++) {
			Ellipse2D.Double note = chord.get(i).getEllipse();
			double x = note.getX();
			double y = note.getY() + 13.5;
			note.setFrame(x, y, 45, 40);
		}
	}
}
