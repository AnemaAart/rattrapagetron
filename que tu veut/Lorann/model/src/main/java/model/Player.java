package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import view.GamePhysics;
import view.Intersection;
import view.Shape;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public abstract class Player extends GamePhysics {

	/** The width. */
	static int WIDTH = 5;

	/** The height. */
	static int HEIGHT = 5;

	/** The jumpheight. */
	static int JUMPHEIGHT = 16;

	/** The color. */
	Color color;

	/** The alive. */
	public boolean alive = true;

	/** The start vel. */
	int startVel = 0;

	/** The lines. */
	ArrayList<Shape> lines = new ArrayList<Shape>();

	/**
	 * Instantiates a new player.
	 *
	 * @param randX
	 *            the rand X
	 * @param randY
	 *            the rand Y
	 * @param velx
	 *            the velx
	 * @param vely
	 *            the vely
	 * @param color
	 *            the color
	 */
	public Player(final int randX, final int randY, final int velx, final int vely, final Color color) {
		super(randX, randY, velx, vely, WIDTH, HEIGHT);
		this.startVel = Math.max(Math.abs(velx), Math.abs(vely));

		this.color = color;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.GamePhysics#accelerate()
	 */
	@Override
	public void accelerate() {
		if ((this.x < 0) || (this.x > this.rightBound)) {
			this.velocityX = 0;
			this.alive = false;
		}
		if ((this.y < 0) || (this.y > this.bottomBound)) {
			this.velocityY = 0;
			this.alive = false;
		}
	}

	/**
	 * Adds the players.
	 *
	 * @param players
	 *            the players
	 */
	abstract void addPlayers(final Player[] players);

	/**
	 * Crash.
	 *
	 * @param i
	 *            the i
	 */
	public void crash(final Intersection i) {
		if (i == Intersection.UP) {
			this.velocityX = 0;
			this.velocityY = 0;
			this.alive = false;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.GamePhysics#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(final Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x - (WIDTH / 2), this.y - (HEIGHT / 2), WIDTH, HEIGHT);
		for (final Shape k : this.lines) {
			k.draw(g);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.GamePhysics#getAlive()
	 */
	@Override
	public boolean getAlive() {
		return this.alive;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.GamePhysics#getPath()
	 */
	@Override
	public ArrayList<Shape> getPath() {
		return this.lines;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see view.GamePhysics#move()
	 */
	@Override
	public abstract void move();

}
