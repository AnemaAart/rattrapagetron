package model;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class TwoPlayer.
 */
@SuppressWarnings("serial")
public class TwoPlayer extends Map {

	/** The player 2. */
	private PlayerPh player2;

	/** The k 1. */
	final Player k1 = null;

	/** The k 2. */
	final Player k2 = null;

	/** The p 1. */
	private boolean p1 = false;

	/** The p 2. */
	private boolean p2 = false;

	/** The tie. */
	private boolean tie = false;

	/**
	 * Instantiates a new two player.
	 *
	 * @param p
	 *            the p
	 */
	public TwoPlayer(final int p) {
		super(p);

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(final KeyEvent e) {
				if (!TwoPlayer.this.player2.getAlive()) {
				}
				switch (e.getKeyCode()) {
				case KeyEvent.VK_Q:
					TwoPlayer.this.player2.setXVelocity(-TwoPlayer.this.VELOCITY);
					TwoPlayer.this.player2.setYVelocity(0);
					break;

				case KeyEvent.VK_D:
					TwoPlayer.this.player2.setXVelocity(TwoPlayer.this.VELOCITY);
					TwoPlayer.this.player2.setYVelocity(0);
					break;
				}

			}

			@Override
			public void keyReleased(final KeyEvent e) {
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Map#addScore()
	 */
	@Override
	public void addScore() {
		if (!this.run) {
			if (this.player2.getAlive()) {
				this.p2 = true;
			} else if (this.player1.getAlive()) {
				this.p1 = true;
			} else {
				this.tie = true;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Map#reset()
	 */
	@Override
	public void reset() {
		this.p1 = false;
		this.p2 = false;
		this.tie = false;
		final int[] start1 = this.getStart();
		this.player1 = new PlayerPh(start1[0], start1[1], start1[2], start1[3], Color.BLUE);
		this.player[0] = this.player1;
		final int[] start2 = this.getStart();
		this.player2 = new PlayerPh(start2[0], start2[1], start2[2], start2[3], Color.ORANGE);
		this.player[1] = this.player2;
		this.timer.start();
		this.requestFocusInWindow();
	}

	/**
	 * Restart game.
	 */
	public void restartGame() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Map#setScore()
	 */
	@Override
	void setScore() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.Map#tick()
	 */
	@Override
	void tick() {

		this.player1.setBounds(this.getWidth(), this.getHeight());
		this.player1.move();

		this.player2.setBounds(this.getWidth(), this.getHeight());
		this.player2.move();

		for (final Player k1 : this.player) {
			for (final Player k2 : this.player) {
				k1.crash(k1.intersects(k2));
			}
		}

		if (!this.player1.getAlive() || !this.player2.getAlive()) {
			this.timer.stop();
			this.run = false;
			this.addScore();
			if (this.player1.getAlive()) {
				this.displayMessage("player1 wins");
			} else if (this.player2.getAlive()) {
				this.displayMessage("player2 wins");
			} else {
				this.displayMessage("tie");
			}
		}
		this.setScore();
		this.repaint();
	}

}
