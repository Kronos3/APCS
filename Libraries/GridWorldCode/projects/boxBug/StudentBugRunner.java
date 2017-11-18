/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import java.util.ArrayList;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.*;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class StudentBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        StudentBug fred = new StudentBug(Color.red);
        Bug joe = new Bug();
        StudentBug frank = new StudentBug(Color.blue);
        Rock may = new Rock();
        
        world.add(new Location(7, 8), fred);
        world.add(new Location(2, 3), joe);
        world.add(new Location(5, 5), frank);
        world.add(new Location(1, 6), may);
        ArrayList<Location> valLocs = fred.getGrid().getValidAdjacentLocations(new Location(28,28));
        System.out.println(valLocs.size());
        System.out.println(fred.getLocation().getDirectionToward(may.getLocation()));
        Actor actor = null;
        System.out.println(new Actor().equals(actor));

        
        world.show();
    }
}