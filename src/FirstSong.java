import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class FirstSong implements Song {
	
	private ArrayList<Chord> chords;
	
	public FirstSong() {
		chords = new ArrayList<>();
		writeSong();
	}
	
	public void writeSong() {
		chords.add(new Chord(new MusicNote(Color.GREEN, 1, "A"), new MusicNote(Color.RED, 1, "A"), 1));
		chords.add(new Chord(new MusicNote(Color.BLUE, 1, "A"), new MusicNote(Color.YELLOW, 1, "A"), 2));
	}
	/*
	public void render(Graphics2D g) {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				chords.get(0).render(g);
			}
			
		}, 0, 5000);
	}
	*/
	private double getTimeToRun(int index) {
		return chords.get(index).getTimeToStart();
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	
	
		// Timer timer = new Timer();
		// timer.schedule(() -> System.out.println("hi"), 45000);
	
	/*
	public void render(Graphics2D g) {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				getChord().get(0).render(g);
			}
		}, 1000);
		
		for(int i = 0; i < getChord().size(); i++)  {
			getChord().get(i).render(g);
		}
		
	}
*/
}
