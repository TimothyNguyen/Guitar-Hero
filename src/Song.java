import java.util.HashMap;
import java.util.Timer;

public class Song {	
	
	private String title;
	private HashMap<Chord, Timer> song;
	
	public Song(String title) {
		this.title = title;
		song = new HashMap<>();
	}
}
