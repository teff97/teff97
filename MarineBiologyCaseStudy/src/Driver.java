import java.util.ArrayList;

public class Driver {

	public static void main (String[]args){
		
		BoundedEnv env = new BoundedEnv(12, 12);
	     Location loc1 = new Location(7, 3);
	     Location loc2 = new Location(7, 4);
	     Direction dir1 = env.getDirection(loc1, loc2);
	     Direction dir2 = dir1.toRight(90);
	     Direction dir3 = dir2.reverse();
	     Location loc3 = env.getNeighbor(loc1, dir3);
	     Location loc4 = env.getNeighbor(new Location(5, 2), dir1);
	     ArrayList x = env.neighborsOf(new Location (2, 2));
	     
	     System.out.println("loc1: " + loc1);
	     System.out.println("loc2: " + loc2);
	     System.out.println("loc3: " + loc3);
	     System.out.println("loc4: " + loc4);
	     System.out.println("dir1: " + dir1);
	     System.out.println("dir2: " + dir2);
	     System.out.println("dir3: " + dir3);
	     System.out.println("ArrayList: " + x);
	    
	     Direction d1 = new Direction("NORTH");
	     System.out.println(d1.inDegrees());
	     Direction d2 = new Direction("SOUTH");
	     System.out.println(d2.inDegrees());
	     Direction d3 = new Direction("EAST");
	     System.out.println(d3.inDegrees());
	     Direction d4 = new Direction("WEST");
	     System.out.println(d4.inDegrees());
	     Direction d5 = new Direction("NORTHEAST");
	     System.out.println(d5.inDegrees());
	     Direction d6 = new Direction("NORTHWEST");
	     System.out.println(d6.inDegrees());
	     Direction d7 = new Direction("SOUTHEAST");
	     System.out.println(d7.inDegrees());
	     Direction d8 = new Direction("SOUTHWEST");
	     System.out.println(d8.inDegrees());
	}
}
