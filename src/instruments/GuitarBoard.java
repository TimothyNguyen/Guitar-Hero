package instruments;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import display.Window;
import instruments.guitar.Bars;
import instruments.guitar.GuitarString;
import instruments.guitar.Ring;

public class GuitarBoard extends JComponent {

	private int x, y;
	private int width, height;
	private Rectangle2D.Double guitar_board;
	private Rectangle2D.Double guitarBorder;
	private Color color;
	private Color colorBorder;
	private GuitarString str1;
	private GuitarString str2;
	private GuitarString str3;
	private GuitarString str4;
	private GuitarString str5;
	private Bars bars;
	private Ring red;
	private Ring yellow;
	private Ring green;
	private Ring blue;
	private Ring orange;
	private ScoreBoard board;


	public GuitarBoard() {
		this.width = 300;
		this.height = 800;
		this.x = Window.getBoardWidth()/2 - (width/2);
		this.y = Window.getBoardHeight()/2 - (height/2);
		this.color = new Color(153, 76, 0);
		this.colorBorder = new Color(102,51,0);
		guitar_board = new Rectangle2D.Double(x, y, width, height);
		guitarBorder = new Rectangle2D.Double(x-10, y, width+20, height);
		str1 = new GuitarString(x + 24, Color.RED);
		str2 = new GuitarString(x + 84, Color.YELLOW);
		str3 = new GuitarString(x + 144, Color.GREEN);
		str4 = new GuitarString(x + 204, Color.BLUE);
		str5 = new GuitarString(x + 264, Color.ORANGE);
		bars = new Bars(width, height);
		red = new Ring(x + 7, Color.RED);
		yellow = new Ring(x + 67, Color.YELLOW);
		green = new Ring(x + 127, Color.GREEN);
		blue = new Ring(x + 187, Color.BLUE);
		orange = new Ring(x + 247, Color.ORANGE);
		board = new ScoreBoard();
	}

	public int getGuitarX(){
		return x;
	}

	public int getGuitarY() {
		return y;
	}

	public int getGuitarWidth() {
		return width;
	}	

	public int getGuitarHeight() {
		return height;
	}

	public void paint(Graphics g) {
		Graphics2D settings = (Graphics2D) g;

		/**
		 * Render the background image
		 */
		try {
			Image bg = ImageIO.read(new File("crowd.jpg"));
			Image img = bg.getScaledInstance(Window.getBoardWidth(), Window.getBoardHeight(), Image.SCALE_DEFAULT);
			settings.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		for(int i = 0; i < chordList.size(); i++) {
			Chord chord = chordList.get(i);
			if(chord.getY() <= 730) {
				if(estimatedTime >= chord.getTimeToStart()) {
					chord.render(g);
				}
			}
			// System.out.println(estimatedTime);
			estimatedTime++;

		}
		*/
		
		//Rendering the scoreboard
		settings.setColor(Color.BLUE);
		settings.setFont(new Font("TimesRoman", Font.BOLD, 40));
		settings.drawString("Score: " + board.getScore(),55, 50); 
		
		/**
		 * Here to render the rings
		 */
		
		Stroke stroke = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		settings.setStroke(stroke);
		settings.setColor(red.getColor());
		settings.draw(red.getEllipse());
		settings.setColor(yellow.getColor());
		settings.draw(yellow.getEllipse());
		settings.setColor(green.getColor());
		settings.draw(green.getEllipse());
		settings.setColor(blue.getColor());
		settings.draw(blue.getEllipse());
		settings.setColor(orange.getColor());
		settings.draw(orange.getEllipse());
		/**
		 * Render the graphics for the guitar board
		 */
		settings.setPaint(colorBorder);
		settings.draw(guitarBorder);
		settings.setPaint(color);
		settings.draw(guitar_board);

		/**
		 * Render the bars and cycle through all bar objects
		 */
		settings.setPaint(bars.getColor());
		for(Line2D.Double bar : bars.getBarLines()) {
			if(bars.onScreen) {
				bars.move();
				settings.draw(bar);
			}
		}
		
		/**
		 * Here to render the strings
		 */
		Stroke stroke2 = new BasicStroke(15, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 0);
		settings.setStroke(stroke2);
		settings.setPaint(str1.getColor());
		settings.draw(str1.getString());
		settings.setPaint(str2.getColor());
		settings.draw(str2.getString());
		settings.setPaint(str3.getColor());
		settings.draw(str3.getString());
		settings.setPaint(str4.getColor());
		settings.draw(str4.getString());
		settings.setPaint(str5.getColor());
		settings.draw(str5.getString());
	}
	
}