package view;

import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/**
 * The Class Line.
 */
public class Line implements Shape {
	
	/** The x. */
	private final int x;
	
	/** The y. */
	private final int y;
	
	/** The x 2. */
	private final int x2;
	
	/** The y 2. */
	private final int y2;

	/**
	 * Instantiates a new line.
	 *
	 * @param x the x
	 * @param y the y
	 * @param x2 the x 2
	 * @param y2 the y 2
	 */
	public Line(final int x, final int y, final int x2, final int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	/* (non-Javadoc)
	 * @see view.Shape#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(final Graphics gc) {
		gc.drawLine(this.x, this.y, this.x2, this.y2);
	}

	/* (non-Javadoc)
	 * @see view.Shape#getEndX()
	 */
	@Override
	public int getEndX() {
		return this.x2;
	}

	/* (non-Javadoc)
	 * @see view.Shape#getEndY()
	 */
	@Override
	public int getEndY() {
		return this.y2;
	}

	/* (non-Javadoc)
	 * @see view.Shape#getStartX()
	 */
	@Override
	public int getStartX() {
		return this.x;
	}

	/* (non-Javadoc)
	 * @see view.Shape#getStartY()
	 */
	@Override
	public int getStartY() {
		return this.y;
	}

	/* (non-Javadoc)
	 * @see view.Shape#isVertical()
	 */
	@Override
	public boolean isVertical() {
		return (this.x == this.x2);
	}
}
