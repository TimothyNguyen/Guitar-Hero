import java.awt.Graphics2D;
import java.util.ArrayList;

public class QuanSong implements Song{

	private ArrayList<Chord> chordList;
	private long startTime;
	private long estimatedTime;
	
	public QuanSong() {
		// super("Here Comes The Sun");
		chordList = new ArrayList<>();
		writeSong(100);
		startTime = System.currentTimeMillis();
		estimatedTime = System.currentTimeMillis() - startTime;
	}
	
	private void writeSong(int numChords) {
		for(int i = 0; i < numChords; i++) {
			int notes = numberOfNotesInAChord();
			if(notes == 5) {
				chordList.add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 4) {
				chordList.add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(),i * 1000));
			}
			else if(notes == 3) {
				chordList.add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 2) {
				chordList.add(new Chord(new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 1) {
				chordList.add(new Chord(new MusicNote(), i * 1000));
			}
		}
	}	

	private int numberOfNotesInAChord() {
		return (int)(Math.random() * 5) + 1;
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
