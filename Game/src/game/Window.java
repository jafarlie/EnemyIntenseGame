package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4369730830015653927L;
	
	public Window(int width, int height, String title, Game game){
		JFrame jframe = new JFrame(title);
		jframe.setPreferredSize(new Dimension(width, height));
		jframe.setMaximumSize(new Dimension(width, height));
		jframe.setMinimumSize(new Dimension(width, height));
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(false);
		jframe.setLocationRelativeTo(null);
		jframe.add(game);
		jframe.setVisible(true);
		game.start();
	}

}
