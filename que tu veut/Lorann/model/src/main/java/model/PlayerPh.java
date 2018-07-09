package model;

import java.awt.Color;

import view.Line;
import view.Shape;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerPh.
 */
public class PlayerPh extends Player {
	
	/**
	 * Instantiates a new player ph.
	 *
	 * @param randX the rand X
	 * @param randY the rand Y
	 * @param velx the velx
	 * @param vely the vely
	 * @param color the color
	 */
	public PlayerPh(final int randX, final int randY, final int velx, final int vely, final Color color) {
		super(randX, randY, velx, vely, color);
	}

	/* (non-Javadoc)
	 * @see model.Player#addPlayers(model.Player[])
	 */
	@Override
	public void addPlayers(final Player[] players) {
	}

	/* (non-Javadoc)
	 * @see model.Player#move()
	 */
	@Override
	public void move() {
		final int a = this.x;
		final int b = this.y;

		this.x += this.velocityX;
		this.y += this.velocityY;
		if (this.lines.size() > 1) {
			final Shape l1 = this.lines.get(this.lines.size() - 2);
			final Shape l2 = this.lines.get(this.lines.size() - 1);
			if ((a == l1.getStartX()) && (l1.getEndY() == l2.getStartY())) {
				this.lines.add(new Line(l1.getStartX(), l1.getStartY(), l2.getEndX(), l2.getEndY()));
				this.lines.remove(this.lines.size() - 2);
				this.lines.remove(this.lines.size() - 2);
			} else if ((b == l1.getStartY()) && (l1.getEndX() == l2.getStartX())) {
				this.lines.add(new Line(l1.getStartX(), l1.getStartY(), l2.getEndX(), l2.getEndY()));
				this.lines.remove(this.lines.size() - 2);
				this.lines.remove(this.lines.size() - 2);
			}
		}
		this.lines.add(new Line(a, b, this.x, this.y));

		this.accelerate();
		this.clip();
	}

}
