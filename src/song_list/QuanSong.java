package song_list;

import java.awt.Color;
import java.util.ArrayList;

import data_structures.ResizingArray;
import objects.Chord;
import objects.MusicNote;

public class QuanSong extends Song{

	private String[] defaultChordNames = {
		"CMAJ", "CMAJ7", "Dm", "Dm7", "Em", "Em7",
		"FMAJ", "FMAJ7", "GMAJ", "G7", "Am", "Am7",
	};
	
	public QuanSong() {
		writeSong(200);
	}

	private void writeSong(int numChords) {
		for(int i = 0; i < numChords; i++) {
			if(chooseRandomChord().equals("CMAJ")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("CMAJ7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Dm")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Dm7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Em")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Em7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("FMAJ")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("FMAJ7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("GMAJ")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("G7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Am")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			} else if(chooseRandomChord().equals("Am7")) {
				getChordList().add(new Chord(new MusicNote("C3", Color.RED), new MusicNote("E3", Color.YELLOW), new MusicNote("G3", Color.GREEN), i * 500));
			}
		}
	}	

	private String chooseRandomChord() {
		return defaultChordNames[(int)(Math.random() * defaultChordNames.length)];
	}
}