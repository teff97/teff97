// AP(r) Computer Science Marine Biology Simulation:
// The Fish class is copyright(c) 2002 College Entrance
// Examination Board (www.collegeboard.com).
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 *  AP&reg; Computer Science Marine Biology Simulation:<br>
 *  A <code>Fish</code> object represents a fish in the Marine Biology
 *  Simulation. Each fish has a unique ID, which remains constant
 *  throughout its life.  A fish also maintains information about its
 *  location and direction in the environment.
 *
 *  <p>
 *  Modification History:
 *  - Modified to support a dynamic population in the environment:
 *    fish can now breed and die.
 *
 *  <p>
 *  The <code>Fish</code> class is
 *  copyright&copy; 2002 College Entrance Examination Board
 *  (www.collegeboard.com).
 *
 *  @author Alyce Brady
 *  @author APCS Development Committee
 *  @version 1 July 2002
 *  @see Environment
 *  @see Direction
 *  @see Location
 **/

public class Fish implements Locatable
{
    // Class Variable: Shared among ALL fish
    private static int nextAvailableID = 1;   // next avail unique identifier

    // Instance Variables: Encapsulated data for EACH fish
    private Environment theEnv;        // environment in which the fish lives
    private int myId;                  // unique ID for this fish
    private Location myLoc;            // fish's location
    private Direction myDir;           // fish's direction
    private Color myColor;             // fish's color
// THE FOLLOWING TWO INSTANCE VARIABLES ARE NEW IN CHAPTER 3 !!!
    private double probOfBreeding;     // defines likelihood in each timestep
    private double probOfDying;        // defines likelihood in each timestep
    private int numOfBreed;				// this answers exercise 6
    private int age;					//this answers exercise 7


  // constructors and related helper methods

    /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public Fish(Environment env, Location loc)
    {
        initialize(env, loc, env.randomDirection(), randomColor(), (1/3), (1/10));
    }

    /** Constructs a fish at the specified location and direction in a
     *  given environment.  The Fish is assigned a random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     *  @param dir    direction the new fish is facing
     **/
    public Fish(Environment env, Location loc, Direction dir)
    {
        initialize(env, loc, dir, randomColor(), (1/3), (1/10));
    }

    /** Constructs a fish of the specified color at the specified location
     *  and direction.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     *  @param dir    direction the new fish is facing
     *  @param col    color of the new fish
     **/
    public Fish(Environment env, Location loc, Direction dir, Color col)
    {
        initialize(env, loc, dir, col, (1/3), (1/10));
    }
    
    public Fish(Environment env, Location loc, Direction dir, Color col, Double breed, Double die){
    	initialize(env, loc, dir, col, breed, die);
    }

    /** Initializes the state of this fish.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment in which this fish will live
     *  @param loc    location of this fish in <code>env</code>
     *  @param dir    direction this fish is facing
     *  @param col    color of this fish
     **/
    private void initialize(Environment env, Location loc, Direction dir,
                            Color col, double breed, double die)
    {
        theEnv = env;
        myId = nextAvailableID;
        nextAvailableID++;
        myLoc = loc;
        myDir = dir;
        myColor = col;
        //this answers exercise 4
        probOfBreeding = breed;
        probOfDying = die;
        // this answers exercise 6
        numOfBreed = 0;
        //this anwers exercise 7
        age = 1;
        theEnv.add(this);

        // object is at location myLoc in environment

// THE FOLLOWING CODE IS NEW IN CHAPTER 3 !!!
        // For now, every fish is equally likely to breed or die in any given
        // timestep, although this could be individualized for each fish.
        probOfBreeding = 1.0/7.0;   // 1 in 7 chance in each timestep
        probOfDying = 1.0/5.0;      // 1 in 5 chance in each timestep
    }

    /** Generates a random color.
     *  @return       the new random color
     **/
    protected Color randomColor()
    {
        // There are 256 possibilities for the red, green, and blue attributes
        // of a color.  Generate random values for each color attribute.
        Random randNumGen = RandNumGenerator.getInstance();
        return new Color(randNumGen.nextInt(256),    // amount of red
                         randNumGen.nextInt(256),    // amount of green
                         randNumGen.nextInt(256));   // amount of blue
    }


  // accessor methods

    /** Returns this fish's ID.
     *  @return        the unique ID for this fish
     **/
    public int id()
    {
        return myId;
    }

    /** Returns this fish's environment.
     *  @return        the environment in which this fish lives
     **/
    public Environment environment()
    {
        return theEnv;
    }

    /** Returns this fish's color.
     *  @return        the color of this fish
     **/
    public Color color()
    {
        return myColor;
    }

    /** Returns this fish's location.
     *  @return        the location of this fish in the environment
     **/
    public Location location()
    {
        return myLoc;
    }

    /** Returns this fish's direction.
     *  @return        the direction in which this fish is facing
     **/
    public Direction direction()
    {
        return myDir;
    }

    /** Checks whether this fish is in an environment.
     *  @return  <code>true</code> if the fish is in the environment
     *           (and at the correct location); <code>false</code> otherwise
     **/
    public boolean isInEnv()
    {
        return environment().objectAt(location()) == this;
    }

    /** Returns a string representing key information about this fish.
     *  @return  a string indicating the fish's ID, location, and direction
     **/
    public String toString()
    {
        return id() + location().toString() + direction().toString();
    }


  // modifier method

// THE FOLLOWING METHOD IS MODIFIED FOR CHAPTER 3 !!!
//       (was originally a check for aliveness and a simple call to move)
    /** Acts for one step in the simulation.
     **/
    public void act()
    {
    	//this answers exercise 7
    	age++;
        // Make sure fish is alive and well in the environment -- fish
        // that have been removed from the environment shouldn't act.
        if ( ! isInEnv() )
            return;

        //this answers exercise 8
        Boolean bred = false;
        
        if(age < 2){
        	bred = breed();
        }
        
        // Try to breed.
        if ( ! bred )
            // Did not breed, so try to move.
            move();

        // Determine whether this fish will die in this timestep.
        Random randNumGen = RandNumGenerator.getInstance();
        //I answered exercise 8 by changing the probOfBreeding in the constructors of the fish
        //probOfDying changes after each act step
        if ( randNumGen.nextDouble() < probOfDying ){
            die();
        }
        probOfDying = (Double) (age/10.0); 
    }


  // internal helper methods

// THE FOLLOWING METHOD IS NEW FOR CHAPTER 3 !!!
    /** Attempts to breed into neighboring locations.
     *  @return    <code>true</code> if fish successfully breeds;
     *             <code>false</code> otherwise
     **/
    protected boolean breed()
    {
        // Determine whether this fish will try to breed in this
        // timestep.  If not, return immediately.
        Random randNumGen = RandNumGenerator.getInstance();
        //I answered exercise 8 by changing the probOfBreeding in the constructors of the fish
        if ( randNumGen.nextDouble() >= probOfBreeding )
            return false;

        // Get list of neighboring empty locations.
        ArrayList emptyNbrs = emptyNeighbors();
        Debug.print("Fish " + toString() + " attempting to breed.  ");
        Debug.println("Has neighboring locations: " + emptyNbrs.toString());

        // If there is nowhere to breed, then we're done.
        if ( emptyNbrs.size() == 0 )
        {
            Debug.println("  Did not breed.");
            return false;
        }

        // Breed to all of the empty neighboring locations.
        for ( int index = 0; index < emptyNbrs.size(); index++ )
        {
            Location loc = (Location) emptyNbrs.get(index);
            generateChild(loc);
        }

      //this answers exercise 6
        numOfBreed ++;
        return true;
    }

// THE FOLLOWING METHOD IS NEW FOR CHAPTER 3 !!!
    /** Creates a new fish with the color of its parent.
     *  @param loc    location of the new fish
     **/
    protected void generateChild(Location loc)
    {
        // Create new fish, which adds itself to the environment.
    	//I switched the constructor so that it was calling randomColor()
    	//this answers exercise 3
        Fish child = new Fish(environment(), loc,
                              environment().randomDirection(), randomColor());       
        Debug.println("  New Fish created: " + child.toString());
    }

    /** Moves this fish in its environment.
     **/
    protected void move()
    {
        // Find a location to move to.
        Debug.print("Fish " + toString() + " attempting to move.  ");
        Location nextLoc = nextLocation();

        // If the next location is different, move there.
        if ( ! nextLoc.equals(location()) )
        {
            // Move to new location.
            Location oldLoc = location();
            changeLocation(nextLoc);

            // Update direction in case fish had to turn to move.
            Direction newDir = environment().getDirection(oldLoc, nextLoc);
            changeDirection(newDir);
            Debug.println("  Moves to " + location() + direction());
        }
        else
            Debug.println("  Does not move.");
    }

    /** Finds this fish's next location.
     *  A fish may move to any empty adjacent locations except the one
     *  behind it (fish do not move backwards).  If this fish cannot
     *  move, <code>nextLocation</code> returns its current location.
     *  @return    the next location for this fish
     **/
    protected Location nextLocation()
    {
        // Get list of neighboring empty locations.
        ArrayList emptyNbrs = emptyNeighbors();

        // Remove the location behind, since fish do not move backwards.
        Direction oppositeDir = direction().reverse();
        Location locationBehind = environment().getNeighbor(location(),
                                                            oppositeDir);
        emptyNbrs.remove(locationBehind);
        Debug.print("Possible new locations are: " + emptyNbrs.toString());

        // If there are no valid empty neighboring locations, then we're done.
        if ( emptyNbrs.size() == 0 )
            return location();

        // Return a randomly chosen neighboring empty location.
        Random randNumGen = RandNumGenerator.getInstance();
        int randNum = randNumGen.nextInt(emptyNbrs.size());
	    return (Location) emptyNbrs.get(randNum);
    }

    /** Finds empty locations adjacent to this fish.
     *  @return    an ArrayList containing neighboring empty locations
     **/
    protected ArrayList emptyNeighbors()
    {
        // Get all the neighbors of this fish, empty or not.
        ArrayList nbrs = environment().neighborsOf(location());

        // Figure out which neighbors are empty and add those to a new list.
        ArrayList emptyNbrs = new ArrayList();
        for ( int index = 0; index < nbrs.size(); index++ )
        {
            Location loc = (Location) nbrs.get(index);
            if ( environment().isEmpty(loc) )
                emptyNbrs.add(loc);
        }

        return emptyNbrs;
    }

    /** Modifies this fish's location and notifies the environment.
     *  @param  newLoc    new location value
     **/
    protected void changeLocation(Location newLoc)
    {
        // Change location and notify the environment.
        Location oldLoc = location();
        myLoc = newLoc;
        environment().recordMove(this, oldLoc);

        // object is again at location myLoc in environment
    }

    /** Modifies this fish's direction.
     *  @param  newDir    new direction value
     **/
    protected void changeDirection(Direction newDir)
    {
        // Change direction.
        myDir = newDir;
    }

// THE FOLLOWING METHOD IS NEW FOR CHAPTER 3 !!!
    /** Removes this fish from the environment.
     **/
    protected void die()
    {
    	//this answers exercise 6 and 7
    	Debug.turnOn();
        Debug.println(toString() + " about to die. NumOfBreed: " + numOfBreed + " Age: " + age);
        environment().remove(this);
        Debug.turnOff();
    }

}
