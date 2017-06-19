package instruments;

import java.awt.geom.Rectangle2D;


public class ScoreBoard{

	private int score;
	
	public ScoreBoard() {
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	

	public void setScore(int s) {
		score += s;
	}
	
	
	
}