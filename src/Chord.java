import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Chord {

	private ArrayList<MusicNote> chord;
	
	public Chord(MusicNote note1, MusicNote note2, MusicNote note3, MusicNote note4) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		chord.add(note3);
		chord.add(note4);
	}
	
	public Chord(MusicNote note1, MusicNote note2, MusicNote note3) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
		chord.add(note3);
	}
	
	public Chord(MusicNote note1, MusicNote note2) {
		chord = new ArrayList<>();
		chord.add(note1);
		chord.add(note2);
	}
	
	public Chord(MusicNote note1) {
		chord.add(note1);
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < chord.size(); i++) {
			chord.get(i).render(g);
		}
		for(int i = 0; i < chord.size(); i++) {
			Ellipse2D.Double note = chord.get(i).getEllipse();
			double x = note.getX();
			double y = note.getY() + 5;
			note.setFrame(x, y, 45, 40);
		}
	}
}
