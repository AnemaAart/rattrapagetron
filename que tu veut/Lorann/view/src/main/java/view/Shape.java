package view;

import java.awt.Graphics;

public interface Shape {

	public void draw(Graphics gc);

	public int getEndX();

	public int getEndY();

	public int getStartX();

	public int getStartY();

	public boolean isVertical();

}
