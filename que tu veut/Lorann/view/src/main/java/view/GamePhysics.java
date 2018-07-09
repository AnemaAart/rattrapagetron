package view;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GamePhysics {

	protected int x;
	protected int y;

	protected int width;
	protected int height;

	protected int velocityX;
	protected int velocityY;

	protected int rightBound;
	protected int bottomBound;

	public GamePhysics(final int x, final int y, final int velocityX, final int velocityY, final int width,
			final int height) {
		this.x = x;
		this.y = y;
		this.velocityX = velocityX;
		this.velocityY = velocityY;
		this.width = width;
		this.height = height;
	}

	public abstract void accelerate();

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

	public abstract void draw(Graphics g);

	public abstract boolean getAlive();

	public abstract ArrayList<Shape> getPath();

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

	public void move() {
		this.x += this.velocityX;
		this.y += this.velocityY;

		this.accelerate();
		this.clip();
	}

	public void setBounds(final int width, final int height) {
		this.rightBound = width - this.width;
		this.bottomBound = height - this.height;
	}

	public void setXVelocity(final int velocityX) {
		if (!((velocityX > 0) && (this.velocityX < 0)) && !((velocityX < 0) && (this.velocityX > 0))) {
			this.velocityX = velocityX;
		}
	}

	public void setYVelocity(final int velocityY) {
		if (!((velocityY > 0) && (this.velocityY < 0)) && !((velocityY < 0) && (this.velocityY > 0))) {
			this.velocityY = velocityY;
		}
	}
}
