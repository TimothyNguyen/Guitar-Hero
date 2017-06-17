package objects;

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
		return chord.get(0).getEllipse().getY();
	}
}