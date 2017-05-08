import javax.swing.JFrame;

public class Window {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Guitar Hero");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new GamePanel());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
}
