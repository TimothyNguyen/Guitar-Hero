import java.util.ArrayList;

public class Song {	
	
	private String title;
	private ArrayList<Chord> chords;
	
	public Song(String title) {
		this.title = title;
		chords = new ArrayList<>();
	}
	
	public ArrayList<Chord> getChord() {
		return chords;
	}
	
	public Chord remove() {
		if(!chords.isEmpty()) {
			return chords.remove(0);
		}
		return null;
	}
	
}
