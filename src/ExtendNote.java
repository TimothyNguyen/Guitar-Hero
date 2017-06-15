import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ExtendNote {

	private double rect_noteX, rect_noteY, rect_width, rect_height;
	private Rectangle2D elongate_note;
	
	public ExtendNote(double x, double y, double noteLength) {
		if(noteLength == 1) {
			this.rect_noteX = x + 5;
			this.rect_noteY = y - 5;
			this.rect_width = 40;
			this.rect_height = 20;
			elongate_note = new Rectangle2D.Double(rect_noteX, rect_noteY, rect_width, rect_height);
		}
	}
	
	public void renderExtendNote(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		/**
		 * If the key is still pressed, have the rectangle size down, score increase
		 * If the key is not pressed, have the rectangle disappear
		 */
		g2d.setColor(Color.WHITE);
		g2d.draw(elongate_note);
	}
	
}
