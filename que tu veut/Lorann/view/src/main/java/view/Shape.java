package view;

import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/**
 * The Interface Shape.
 */
public interface Shape {

	/**
	 * Draw.
	 *
	 * @param gc the gc
	 */
	public void draw(Graphics gc);

	/**
	 * Gets the end X.
	 *
	 * @return the end X
	 */
	public int getEndX();

	/**
	 * Gets the end Y.
	 *
	 * @return the end Y
	 */
	public int getEndY();

	/**
	 * Gets the start X.
	 *
	 * @return the start X
	 */
	public int getStartX();

	/**
	 * Gets the start Y.
	 *
	 * @return the start Y
	 */
	public int getStartY();

	/**
	 * Checks if is vertical.
	 *
	 * @return true, if is vertical
	 */
	public boolean isVertical();

}
