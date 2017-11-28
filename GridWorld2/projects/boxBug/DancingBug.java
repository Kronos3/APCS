import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
	private int[] direction;
	private int directionPointer;


	/**
	 * Construct a DancingBug given directions
	 * @param direction the list of directions to use
	 */
	public DancingBug(int[] direction)
	{
		directionPointer = 0;
		this.direction = direction;
	}

	@Override
	public void act()
	{
		for(int i = 0; i < direction[directionPointer]; i++)
		{
			turn();
		}

		if(directionPointer + 1 == direction.length)
		{
			directionPointer = 0;
		}
		else
		{
			directionPointer++;
		}

		super.act();


	}
}
