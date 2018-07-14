package view;

import java.awt.Graphics;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePhysics.
 */
public abstract class GamePhysics {

	/** The x. */
	protected int x;

	/** The y. */
	protected int y;

	/** The width. */
	protected int width;

	/** The height. */
	protected int height;

	/** The velocity X. */
	protected int velocityX;

	/** The velocity Y. */
	protected int velocityY;

	/** The right bound. */
	protected int rightBound;

	/** The bottom bound. */
	protected int bottomBound;

	/**
	 * Instantiates a new game physics.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param velocityX
	 *            the velocity X
	 * @param velocityY
	 *            the velocity Y
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public GamePhysics(final int x, final int y, final int velocityX, final int velocityY, final int width,
			final int height) {
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.width = width;
		this.height = height;
	}

	/**
	 * Accelerate.
	 */
	public abstract void accelerate();

	/**
	 * Clip.
	 */
	public void clip() {
		if (this.x < 0) {
			this.x = 0;
		} else if (this.x > this.rightBound) {
			this.x = this.rightBound;
		}

		if (this.y < 0) {
			this.y = 0;
		} else if (this.y > this.bottomBound) {
			this.y = this.bottomBound;
		}
	}

	/**
	 * Draw.
	 *
	 * @param g
	 *            the g
	 */
	public abstract void draw(Graphics g);

	/**
	 * Gets the alive.
	 *
	 * @return the alive
	 */
	public abstract boolean getAlive();

	/**
	 * Gets the path.
	 *
	 * @return the path
	 */
	public abstract ArrayList<Shape> getPath();

	/**
	 * Gets the velocity X.
	 *
	 * @return the velocity X
	 */
	public int getVelocityX() {
		return this.velocityX;
	}

	/**
	 * Gets the velocity Y.
	 *
	 * @return the velocity Y
	 */
	public int getVelocityY() {
		return this.velocityY;
	}

	/**
	 * Intersects.
	 *
	 * @param other
	 *            the other
	 * @return the intersection
	 */
	public Intersection intersects(final GamePhysics other) {
		if (other != this) {
			if (((other.y - (other.height / 2)) <= (this.y + (this.height / 2)))
					&& ((other.y + (other.height / 2)) >= (this.y - (this.height / 2)))
					&& ((other.x - (other.width / 2)) <= (this.x + (this.width / 2)))
					&& ((other.x + (other.width / 2)) >= (this.x - (this.width / 2)))) {
				return Intersection.UP;
			}
		}
		final ArrayList<Shape> pa = other.getPath();
		for (int i = 0; i < (pa.size() - 1); i++) {
			final Shape k = pa.get(i);
			final int x1 = k.getStartX();
			final int y1 = k.getStartY();
			final int x2 = k.getEndX();
			final int y2 = k.getEndY();

			if (y1 == y2) {
				if ((Math.abs(y1 - this.y) <= (this.height / 2))
						&& ((this.x >= Math.min(x1, x2)) && (this.x <= Math.max(x1, x2)))) {
					return Intersection.UP;
				}
			} else if (x1 == x2) {
				if ((Math.abs(x1 - this.x) <= (this.width / 2))
						&& ((this.y >= Math.min(y1, y2)) && (this.y <= Math.max(y1, y2)))) {
					return Intersection.UP;
				}
			}
		}
		return Intersection.NONE;
	}

	/**
	 * Move.
	 */
	public void move() {
		this.x += this.velocityX;
		this.y += this.velocityY;

		this.accelerate();
		this.clip();
	}

	/**
	 * Sets the bounds.
	 *
	 * @param width
	 *            the width
	 * @param height
	 *            the height
	 */
	public void setBounds(final int width, final int height) {
		this.rightBound = width - this.width;
		this.bottomBound = height - this.height;
	}

	/**
	 * Sets the velocity X.
	 *
	 * @param velocityX
	 *            the new velocity X
	 */
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * Sets the velocity Y.
	 *
	 * @param velocityY
	 *            the new velocity Y
	 */
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * Sets the x velocity.
	 *
	 * @param velocityX
	 *            the new x velocity
	 */
	public void setXVelocity(final int velocityX) {
		if (!((velocityX > 0) && (this.velocityX < 0)) && !((velocityX < 0) && (this.velocityX > 0))) {
			this.velocityX = velocityX;
		}
	}

	/**
	 * Sets the y velocity.
	 *
	 * @param velocityY
	 *            the new y velocity
	 */
	public void setYVelocity(final int velocityY) {
		if (!((velocityY > 0) && (this.velocityY < 0)) && !((velocityY < 0) && (this.velocityY > 0))) {
			this.velocityY = velocityY;
		}
	}
}
