import java.awt.Color;
import java.awt.Graphics2D;

public class FirstSong extends Song{
	
	public FirstSong() {
		super("Here Comes The Sun");
		writeSong();
	}
	
	public void writeSong() {
		getChord().add(new Chord(new MusicNote(Color.GREEN, 1, "A"), new MusicNote(Color.RED, 1, "A")));
	}
	
	public void render(Graphics2D g) {
		for(int i = 0; i < getChord().size(); i++)  {
			getChord().get(i).render(g);
		}
	}
	
}
