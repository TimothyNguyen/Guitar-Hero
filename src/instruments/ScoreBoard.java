package instruments;

import java.awt.geom.Rectangle2D;


public class ScoreBoard{

	private static int score;
	
	public ScoreBoard() {
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	

	public static void setScore(int s) {
		score += s;
	}
	
	
	
}