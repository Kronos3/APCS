import info.gridworld.actor.Bug;

import java.awt.*;

public class ZBug extends Bug
{
	private int steps;
	private int sideLength;
	private boolean isDrawingDiagonal;
	private int spacesMoved;

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * @param length the side length
	 */
	public ZBug(int length, Color initialColor)
	{
		isDrawingDiagonal = false;
		spacesMoved = 0;
		setColor(initialColor);
		steps = 0;
		sideLength = length;
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act()
	{
		if(!canMove())
			return;

		if(spacesMoved == (sideLength + 1) * 3)
			return;

		if (steps < sideLength && canMove())
		{
			move();
			steps++;
		}
		else if(!isDrawingDiagonal)
		{
			isDrawingDiagonal = true;
			turn();
			turn();
			turn();
			steps = 0;
		}
		else
		{
			isDrawingDiagonal = false;

			turn();
			turn();
			turn();
			turn();
			turn();
			steps = 0;
		}

		spacesMoved++;
	}
}
