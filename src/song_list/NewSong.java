package song_list;

import java.awt.Color;

import objects.Chord;
import objects.MusicNote;

public class NewSong extends Song {

	public NewSong() {
		writeSong();
	}
	// o F this
	public void writeSong() {
		for(int i = 0; i < 100; i++) {
			getChordList().add(new Chord(new MusicNote(Color.GREEN, 1, "A2"), new MusicNote(Color.RED, 1, "C3"), 0));
			getChordList().add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 5000));
			getChordList().add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 10000));
			getChordList().add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 15000));
			getChordList().add(new Chord(new MusicNote(Color.YELLOW, 1, "A"), new MusicNote(Color.RED, 1, "C"), 20000));
			getChordList().add(new Chord(new MusicNote(Color.YELLOW, 1, "A"), new MusicNote(Color.RED, 1, "C"), 
					new MusicNote(Color.BLUE, 1, "F"), new MusicNote(Color.GREEN, 1, "D"), new MusicNote(Color.ORANGE, 1, "G#"), 25000));
		}
	}	
}

