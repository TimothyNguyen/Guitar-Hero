import java.awt.Graphics2D;
import java.util.ArrayList;

public class QuanSong extends Song{


	public QuanSong() {
		writeSong(100);
	}

	private void writeSong(int numChords) {
		for(int i = 0; i < numChords; i++) {
			int notes = numberOfNotesInAChord();
			if(notes == 5) {
				getChordList().add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 4) {
				getChordList().add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), new MusicNote(),i * 1000));
			}
			else if(notes == 3) {
				getChordList().add(new Chord(new MusicNote(), new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 2) {
				getChordList().add(new Chord(new MusicNote(), new MusicNote(), i * 1000));
			}
			else if(notes == 1) {
				getChordList().add(new Chord(new MusicNote(), i * 1000));
			}
		}
	}	

	private int numberOfNotesInAChord() {
		return (int)(Math.random() * 5) + 1;
	}

	public void render(Graphics2D g) {
		for(int i = 0; i < getChordList().size(); i++) {
			// This is where the boolean array from window is from
			boolean[] arr = Window.getList();
			Chord chord = getChordList().get(i);
			if(chord.getY() >= 670 && chord.getY() <= 700 && arr[5]) {
				boolean allNotesUsed = true;
				for(int j = 0; j < chord.getChord().size(); j++) {
					int noteNum = chord.getChord().get(j).getColorNum();
					if(!arr[noteNum]) {
						allNotesUsed = false;
						chord.render(g);
						break;
					} else {
						continue;
					}
				}
				if(allNotesUsed) {
					Synth s = new Synth(chord.getChord(), 100, chord.getChord().get(0).getNoteLength());
					// s.playNote();
					getChordList().remove(chord);
					ScoreBoard.setScore(50);
					if(i > -1) { // this to prevent accessing -1
						i--; 
					}
				} 
			} else if(chord.getY() <= 730) {
				if(getEstimatedTime() >= chord.getTimeToStart()) {
					chord.render(g);
				}
			}  
			else {
				getChordList().remove(chord);
				i--;
			}
			incrementEstimatedTime();
		}
	}
}
