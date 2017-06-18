package song_list;

import java.awt.Graphics2D;
import java.util.ArrayList;

import display.Window;
import objects.Chord;

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

	public ArrayList<Chord> getChordList() {
		return chordList;
	}

	public long getEstimatedTime() {
		return estimatedTime;
	}

	public void incrementEstimatedTime() {
		estimatedTime++;
	}
/*
	public void move() {
		for(int i = 0; i < getChordList().size(); i++) {
			// This is where the boolean array from window is from
			boolean[] arr = Window.getList();
			Chord chord = getChordList().get(i);
			if(chord.getY() >= 670 && chord.getY() <= 720 && arr[5]) {
				boolean allNotesUsed = true;
				for(int j = 0; j < chord.getChord().size(); j++) {
					int noteNum = chord.getChord().get(j).getColorNum();
					if(!arr[noteNum]) {
						allNotesUsed = false;
						break;
					} else {
						continue;
					}
				}
				if(allNotesUsed) {
					
				}
			}
		} 
	}
	*/
}