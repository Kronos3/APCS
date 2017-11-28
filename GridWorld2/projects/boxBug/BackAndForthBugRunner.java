import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.*;

public class BackAndForthBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Bug d = new BackAndForthBug(5, Color.RED);
		world.add(new Location(0, 0), d);
		world.add(new Location(0, 2), new Rock());
		world.show();
	}
}
