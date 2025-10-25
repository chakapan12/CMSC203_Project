/*
 * Class: CMSC203 
 * Instructor: Farnaz Eivazi
 * Description: This class represents plot object
 * different approaches.
 * Due: 10/27/2025
 * Platform/compiler MacOS
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Chakapan Kanchana
*/

/**
 * This class represents plot object
 * 
 * @author Chakapan Kanchana
 */
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;

	/**
	 * Creates a default Plot with width and depth of 1.
	 */
	public Plot() {
		width = 1;
		depth = 1;
	}

	/**
	 * Creates a Plot using the given values.
	 * 
	 * @param x     the x coordinate of the plot
	 * @param y     the y coordinate of the plot
	 * @param width the width coordinate of the plot
	 * @param depth the depth coordinate of the plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * Creates a new plot given another plot. This constructor must call an
	 * appropriate existing constructor.
	 * 
	 * @param otherPlot the plot to make a copy of
	 */
	public Plot(Plot otherPlot) {
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}

	/**
	 * Determines if the given plot instance is overlapped by the current plot.
	 * 
	 * @param plot the plot to test against and check if overlaps
	 * @return true if the two plots overlap, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		// if one plot is on the left side of the other
		if (this.x + this.width <= plot.x || plot.x + plot.width <= this.x)
			return false;

		// if one plot is above or below the other
		if (this.y + this.depth <= plot.y || plot.y + plot.depth <= this.y)
			return false;

		// otherwise return true
		return true;
	}

	/**
	 * Determines if the given plot is encompassed by (is contained by) this plot.
	 * Note that the determination should be inclusive, in other words, if an edge
	 * lies on the edge of the current plot, this is acceptable.
	 * 
	 * @param plot the plot to test against and check if encompasses
	 * @return true if the given plot is encompassed by this plot, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		if (plot == null)
			return false;

		// Ensure plot starts at non-negative
		if (plot.x < 0 || plot.y < 0)
			return false;

		// Check all 4 edges of plot fit within this plot (inclusive)
		return plot.x >= this.x && plot.y >= this.y && (plot.x + plot.width) <= (this.x + this.width)
				&& (plot.y + plot.depth) <= (this.y + this.depth);
	}

	/**
	 * Get the x.
	 * 
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the y
	 * 
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the depth
	 * 
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Set the x.
	 * 
	 * @param x the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Set the y.
	 * 
	 * @param y the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Set the width
	 * 
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Set the depth
	 * 
	 * @param depth the new depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * 
	 * Compares this plot to another object for equality.
	 * 
	 * @param obj the object to compare with this plot
	 * @return true if the given object is also a Plot with identical x, y, width,
	 *         and depth values; false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		return depth == other.depth && width == other.width && x == other.x && y == other.y;
	}

	/**
	 * Represents a Plot object in the following String format. x,y,width,depth
	 * 
	 * @return the string representation of a plot.
	 */
	@Override
	public String toString() {
		return x + "," + y + "," + width + "," + depth;
	}

}
