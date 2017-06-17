import java.awt.Graphics2D;
import java.util.ArrayList;

public class Song {	
	
	private ArrayList<Chord> chordList;
	private long startTime;
	private long estimatedTime;
	
	public Song() {
		chordList = new ArrayList<>();
		startTime = System.currentTimeMillis();
		estimatedTime = System.currentTimeMillis() - startTime;
	}
	
	private void writeSong(int numChords) {
		// nothing here
	}
	
	public void render(Graphics2D g) {
		// nothing	here
	}
	
	public ArrayList<Chord> getChordList() {
		return chordList;
	}
	
	public long getEstimatedTime() {
		return estimatedTime;
	}
	
	public void incrementEstimatedTime() {
		estimatedTime++;
	}
	
}
