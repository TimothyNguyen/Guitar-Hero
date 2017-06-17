import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

public class Chord {

	private ArrayList<MusicNote> chord;
	private double time;
	
	public Chord(String str) {
		
	}
	
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
	
	public ArrayList<MusicNote> getChord() {
		return chord;
	}
	
	public double getTimeToStart() {
		return time;
	}
	
	public double getY() {
		return chord.get(0).getEllipse().getY();
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
			if(chord.get(i).getNoteLength() > 0.25) {
				/*
				Rectangle2D.Double elon_note = chord.get(i).getElongatedNote();
				double e_x = elon_note.getX();
				double e_y = elon_note.getY() + 13.5;
				elon_note.setFrame(e_x, e_y, elon_note.getWidth(), elon_note.getHeight());
				*/
			}
		}
	}
}
