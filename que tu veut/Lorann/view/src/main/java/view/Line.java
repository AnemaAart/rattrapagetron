package view;

import java.awt.Graphics;

public class Line implements Shape {
	private final int x;
	private final int y;
	private final int x2;
	private final int y2;

	public Line(final int x, final int y, final int x2, final int y2) {
		this.x = x;
		this.y = y;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(final Graphics gc) {
		gc.drawLine(this.x, this.y, this.x2, this.y2);
	}

	@Override
	public int getEndX() {
		return this.x2;
	}

	@Override
	public int getEndY() {
		return this.y2;
	}

	@Override
	public int getStartX() {
		return this.x;
	}

	@Override
	public int getStartY() {
		return this.y;
	}

	@Override
	public boolean isVertical() {
		return (this.x == this.x2);
	}
}
