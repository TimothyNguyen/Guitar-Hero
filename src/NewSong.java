
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class NewSong implements Song {

	private ArrayList<Chord> chordList;
	private long startTime;
	private long estimatedTime;
	
	public NewSong() {
		chordList = new ArrayList<>();
		writeSong();
		startTime = System.currentTimeMillis();
		estimatedTime = System.currentTimeMillis() - startTime;
	}
	// o F this
	public void writeSong() {
		for(int i = 0; i < 100; i++) {
			chordList.add(new Chord(new MusicNote(Color.GREEN, 1, "A"), new MusicNote(Color.RED, 1, "A"), 0));
			chordList.add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 5000));
			chordList.add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 10000));
			chordList.add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 15000));
			chordList.add(new Chord(new MusicNote(Color.YELLOW, 1, "A"), new MusicNote(Color.RED, 1, "C"), 20000));
			chordList.add(new Chord(new MusicNote(Color.YELLOW, 1, "A"), new MusicNote(Color.RED, 1, "C"), 
					new MusicNote(Color.BLUE, 1, "F"), new MusicNote(Color.GREEN, 1, "D"), new MusicNote(Color.ORANGE, 1, "G#"), 25000));
		}
		
	}	

	public void render(Graphics2D g) {
		for(int i = 0; i < chordList.size(); i++) {
			Chord chord = chordList.get(i);
			if(estimatedTime >= chord.getTimeToStart()) {
				chord.render(g);
			}
			// System.out.println(estimatedTime);
			estimatedTime++;
		}
	}
}
