package song_list;

import java.awt.Graphics2D;
import java.util.ArrayList;

import display.Window;
import instruments.ScoreBoard;
import instruments.guitar.Chord;
import instruments.guitar.MusicNote;

public class Song {	

	private ArrayList<Chord> chordList;
	private ArrayList<MusicNote> chord;
	private long startTime;
	private long estimatedTime;
	private boolean[] guitar_keys;
	
	/**
	 * 
	 */
	
	public Song() {
		chordList = new ArrayList<>();
		startTime = System.currentTimeMillis();
		estimatedTime = System.currentTimeMillis() - startTime;
		guitar_keys = Window.getGuitarKeyList();
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < getChordList().size(); i++)  {
			Chord chord = getChordList().get(i);
			if(checkNotesPressed(chord)) {
				getChordList().remove(chord);
				ScoreBoard.setScore(50);
				if(i > -1) { // this to prevent accessing -1
					i--; 
				}
			} else if(chord.getY() <= 730) {
				if(getEstimatedTime() >= chord.getTimeToStart()) {
					chord.drawChords(g);
				}
			} else {
				getChordList().remove(chord);
				i--;
			}
			incrementEstimatedTime();
			//System.out.println(getEstimatedTime());
		}
	}
	
	private boolean checkNotesPressed(Chord chord) {
		if(checkLocation(chord)) {
			setGuitarKeysToTrue();
			boolean allNotesUsed = true;
			for(int j = 0; j < chord.getChord().size(); j++) {
				int noteNum = chord.getChord().get(j).getColorNum();
				if(!(guitar_keys[noteNum])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private void writeSong(int numChords) {
		// nothing here
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
	
	private boolean checkLocation(Chord chord) {
		return (chord.getY() >= 670 && chord.getY() <= 700 && Window.getGuitarKeyList()[5]);
	}
	
	private void setGuitarKeysToTrue() {
		guitar_keys[0] = true;
		guitar_keys[1] = true;
		guitar_keys[2] = true;
		guitar_keys[3] = true;
		guitar_keys[4] = true;
	}
}