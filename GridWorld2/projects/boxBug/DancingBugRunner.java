import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

public class DancingBugRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		world.setGrid(new UnboundedGrid<Actor>());
		DancingBug d = new DancingBug(new int[] {0, 6, 4 ,9, 10, 3});
		world.add(new Location(0, 0), d);

		world.show();
	}
}
