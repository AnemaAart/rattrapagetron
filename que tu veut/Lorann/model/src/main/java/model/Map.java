package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
@SuppressWarnings("serial")
public abstract class Map extends JComponent {

	/** The player 1. */
	PlayerPh player1;

	/** The player. */
	Player[] player;

	/** The colors. */
	Color[] colors = { Color.CYAN, Color.PINK, Color.WHITE, Color.YELLOW, Color.BLUE, Color.ORANGE, Color.RED,
			Color.GREEN };

	/** The rand. */
	Random rand = new Random();

	/** The mapwidth. */
	int MAPWIDTH = 600;

	/** The mapheight. */
	int MAPHEIGHT = 400;

	/** The velocity. */
	int VELOCITY = 3;

	/** The i. */
	int i = 0;

	/** The score 1. */
	JLabel score1;

	/** The score 2. */
	JLabel score2;

	/** The interval. */
	int interval = 20;

	/** The timer. */
	Timer timer = null;

	/** The run. */
	boolean run = true;

	/**
	 * Instantiates a new map.
	 *
	 * @param p
	 *            the p
	 */
	public Map(final int p) {
		this.setBackground(Color.BLACK);

		this.player = new Player[p];

		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		this.setFocusable(true);

		this.timer = new Timer(this.interval, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Map.this.tick();
			}
		});
		this.timer.start();

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(final KeyEvent e) {
				if (!Map.this.player1.getAlive()) {
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Map.this.player1.setXVelocity(-Map.this.VELOCITY);
					Map.this.player1.setYVelocity(0);
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Map.this.player1.setXVelocity(Map.this.VELOCITY);
					Map.this.player1.setYVelocity(0);

				}
			}

			@Override
			public void keyReleased(final KeyEvent e) {
			}
		});
	}

	/**
	 * Adds the score.
	 */
	abstract void addScore();

	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.MAPWIDTH, this.MAPHEIGHT);
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int[] getStart() {
		final int[] start = new int[4];
		final int xnew = 50 + this.rand.nextInt(100);
		final int ynew = 50 + this.rand.nextInt(100);
		final int ra = this.rand.nextInt(2);
		int velx = 0;
		int vely = 0;
		if (ra == 0) {
			if (xnew < 250) {
				velx = this.VELOCITY;
			} else {
				velx = -this.VELOCITY;
			}
		} else {
			if (ynew < 250) {
				vely = this.VELOCITY;
			} else {
				vely = -this.VELOCITY;
			}
		}
		start[0] = xnew;
		start[1] = ynew;
		start[2] = velx;
		start[3] = vely;
		return start;
	}

	/**
	 * Gets the velocity.
	 *
	 * @return the velocity
	 */
	public int getVelocity() {
		return this.VELOCITY;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.MAPWIDTH, this.MAPHEIGHT);
		for (final Player p : this.player) {
			if (p != null) {
				p.draw(g);
			}
		}
	}

	/**
	 * Reset.
	 */
	abstract void reset();

	/**
	 * Sets the score.
	 */
	abstract void setScore();

	/**
	 * Tick.
	 */
	abstract void tick();

	/*
	 * public void closeAll() { this.frame.dispose(); }
	 */
}
