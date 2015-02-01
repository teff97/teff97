
public class Equation {
	int storeLocation[] = new int[2];
	int locationVarOne[] = new int[2];
	int locationVarTwo[] = new int[2];
	Character operation;

	public Equation (String input){
		String parseInput[] = input.split(" ");
		storeLocation = parseLocation(parseInput[0]);
		locationVarOne = parseLocation(parseInput[2]);
		operation = parseInput[3].charAt(0);
		locationVarTwo = parseLocation(parseInput[4]);	
	}
	
	public double evaluate(Cell[][] cells){
		if(operation == '+'){
			return cells[locationVarOne[0]][locationVarOne[1]].doubleNumSave + cells[locationVarTwo[0]][locationVarTwo[1]].doubleNumSave;
		}else if(operation == '-'){
			return cells[locationVarOne[0]][locationVarOne[1]].doubleNumSave + cells[locationVarTwo[0]][locationVarTwo[1]].doubleNumSave;
		}else if(operation == '*'){
			return cells[locationVarOne[0]][locationVarOne[1]].doubleNumSave + cells[locationVarTwo[0]][locationVarTwo[1]].doubleNumSave;
		}else if(operation == '/'){
			return cells[locationVarOne[0]][locationVarOne[1]].doubleNumSave + cells[locationVarTwo[0]][locationVarTwo[1]].doubleNumSave;
		}else{
			return 0.0;
		}
	}
	
	public static int[] parseLocation (String location){
		//example: A2
		int [] inputLocation = new int[2];
		inputLocation[0] = (int) (location.charAt(0)-65);
		inputLocation[1] = Integer.parseInt(location.substring(1))-1;
		return inputLocation;
	}
}
