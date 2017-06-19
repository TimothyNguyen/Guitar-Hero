package song_list.guitar_render_songs;

import java.awt.Graphics2D;

import display.Window;
import instruments.guitar.Chord;

public class GuitarRendering {

	protected boolean checkLocation(Chord chord) {
		return (chord.getY() >= 670 && chord.getY() <= 720 && Window.getList()[5][0]);
	}
	
	public void render(Graphics2D g) { 
		
	}
	
	public void checkNotesPressed(Chord chord) {
		boolean[][] arr = Window.getList();
		for(int i = 0; i < chord.getChord().size(); i++) {
			int noteNum = chord.getChord().get(i).getColorNum();
			
		}
	}
}
