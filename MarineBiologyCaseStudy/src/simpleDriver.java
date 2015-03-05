
public class simpleDriver {

	private static final int ENV_ROWS = 10;      
    private static final int ENV_COLS = 10;
    
	public static void main (String[]args){
		
		BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
        
        
        Location loc1 = new Location(7, 3);
        Location loc2 = new Location(2, 6);
        Location loc3 = new Location(4, 8);
        Fish f1 = new Fish(env, loc1);
        Fish f2 = new Fish(env, loc2);
        
        System.out.println("env.numObjects() " + env.numObjects());
        
        Locatable allObjects [] = env.allObjects();
        for(int idx = 0; idx < allObjects.length; idx++){
        	System.out.println("Object " + allObjects[idx]);
        }
        
        System.out.println("env.isEmpty(loc1) " + env.isEmpty(loc1));
        System.out.println("env.isEmpty(loc3) " + env.isEmpty(loc3));
        System.out.println("env.objectAt(loc3) " + env.objectAt(loc3));
        
        Fish f3 = new Fish(env, loc3);
        Fish f4 = new Fish(env, new Location(1, 3));
        
        System.out.println("env.numObjects() " + env.numObjects());
        Locatable allObjects2 [] = env.allObjects();
        for(int idx = 0; idx < allObjects.length; idx++){
        	System.out.println("Object " + allObjects2[idx]);
        }
        
        env.remove(f4);
        env.remove(f3);
        
        System.out.println("env.numObjects() " + env.numObjects());
        Locatable allObjects3 [] = env.allObjects();
        for(int idx = 0; idx < allObjects.length; idx++){
        	System.out.println("Object " + allObjects3[idx]);
        }
        
        Fish f5 = new Fish(env, new Location(1, 2));
        
        env.add(f5);
	}
}
