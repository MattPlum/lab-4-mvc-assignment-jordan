/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model {

	private final int frameWidth;
	private final int frameHeight;
	private final int imgWidth;
	private final int imgHeight;

	private int xloc = 0;
	private int yloc = 0;
	private final int xIncr = 8;
	private final int yIncr = 2;
	private int direction = 0;

	public Model(int frameWidth, int frameHeight, int imgWidth, int imgHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
	}

	public int getX() {
		return xloc;
	}

	public int getY() {
		return yloc;
	}
	
	public int getDirect() {
		return direction;
	}

	public void updateLocationAndDirection() {
		if (isAtBoundary()) {
			direction++;
		}
		move();
	}

	public void move() {
		if (direction % 4 == 0) {
			xloc += xIncr;
			yloc += yIncr;
		}
		if (direction % 4 == 1) {
			xloc -= xIncr;
			yloc += yIncr;
		}
		if (direction % 4 == 2) {
			xloc -= xIncr;
			yloc -= yIncr;
		}
		if (direction % 4 == 3) {
			xloc += xIncr;
			yloc -= yIncr;
		}
	}

	private boolean isAtBoundary()
	{
		if (xloc > (frameWidth - imgWidth) || yloc > (frameHeight - imgHeight) || yloc < 0 || xloc < 0) {
			return true;
		}
		else return false;
	}
}
