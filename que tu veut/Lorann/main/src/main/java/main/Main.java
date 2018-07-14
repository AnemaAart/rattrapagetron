package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// TODO: Auto-generated Javadoc
/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Main implements Runnable {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {

		SwingUtilities.invokeLater(new Main());

	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		final JFrame frame = new JFrame("Tron");
		frame.setBackground(Color.BLACK);
		frame.setPreferredSize(new Dimension(600, 400));
		frame.setResizable(false);
		frame.setLocation(600, 400);

		final model.TwoPlayer level = new model.TwoPlayer(2);
		level.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		frame.setLayout(new BorderLayout());
		frame.add(level, BorderLayout.CENTER);
		frame.update(frame.getGraphics());
		level.requestFocusInWindow();
		level.revalidate();

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		level.reset();
	}

}
