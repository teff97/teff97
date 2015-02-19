
public class Equation {
	String fullEquation;
	int storeLocation[] = new int[2];
	

	public Equation (String input){
		fullEquation = input.substring(input.indexOf('=') + 2, input.length());
		storeLocation = parseLocation(input.substring(0, 2));
		
		
		/*
		String parseInput[] = input.split(" ");
		char operation[] = new char[(parseInput.length-3)/2];
		int equationParts[][] = new int[(parseInput.length-1)/2][];
		storeLocation = parseLocation(input.substring(0, 2));
		int operationCounter = 0;
		int locationCounter = 0;
		for(int idx = 2; idx < parseInput.length;idx++){
			if(parseInput[idx].length() == 1 && (parseInput[idx].charAt(0) == '-' || parseInput[idx].charAt(0) == '+' || parseInput[idx].charAt(0) == '*'|| parseInput[idx].charAt(0) == '/')){
				operation[operationCounter] = parseInput[idx].charAt(0);
				operationCounter++;
			}else if(parseInput[idx].length() == 2 && parseInput[idx].charAt(0) > 64 && parseInput[idx].charAt(0) < 91){
				equationParts[locationCounter] = parseLocation(parseInput[idx]);
				locationCounter++;
			}else{
				equationParts[locationCounter] = parseNumber(parseInput[idx]);
			}
		}
		*/
	}
	
	/*public Equation(String StoreLocation, String location, char operator, int num){
		storeLocation = parseLocation(StoreLocation);
		
		operation = operator;
		numberOne = num;
	}*/
	
	public double evaluate(Cell[][] cells){
		double ans = 0.0;
		String withValues = "";
		String equationSplit[] = fullEquation.split(" ");
		for(int idx = 0; idx < equationSplit.length; idx ++){
			if(textExel.isLocation(equationSplit[idx])){
				int temp[] = parseLocation(equationSplit[idx]);
				withValues = withValues + cells[temp[0]][temp[1]].doubleNumPrint + "";
			}else if(isOperator(equationSplit[idx])){
				withValues = withValues + " " + equationSplit[idx] + " ";
			}else{
				withValues = withValues + equationSplit[idx] + "";
			}
		}
		
		
		String solutionString = withValues;
		
		while(!isNumber(solutionString)){
			String valueArray[] = solutionString.split(" ");
			double x = 0.0;
			if(valueArray[1].charAt(0) == '+'){
				x = Double.parseDouble(valueArray[0]) + Double.parseDouble(valueArray[2]);
			}else if(valueArray[1].charAt(0) == '-'){
				x = Double.parseDouble(valueArray[0]) - Double.parseDouble(valueArray[2]);
			}else if(valueArray[1].charAt(0) == '*'){
				x = Double.parseDouble(valueArray[0]) * Double.parseDouble(valueArray[2]);
			}else if(valueArray[1].charAt(0) == '/'){
				x = Double.parseDouble(valueArray[0]) / Double.parseDouble(valueArray[2]);
			}
			
			int idx = 0;
			int space = 0;
			for(idx = 0; idx < solutionString.length() && space != 3; idx ++){
				if(solutionString.charAt(idx) == ' '){
					space++;
				}
			}
			
			if(valueArray.length != 3){
				solutionString = x + solutionString.substring(idx-1);
			}else{
				solutionString = x + "";
			}
			
		}
		
		ans = Double.parseDouble(solutionString);
			return ans;
	}
	
	public static int[] parseLocation (String location){
		//example: A2
		int [] inputLocation = new int[2];
		inputLocation[0] = (int) (location.charAt(0)-65);
		inputLocation[1] = Integer.parseInt(location.substring(1))-1;
		return inputLocation;
	}
	
	public static String getLocation (int []inputLocation){
		char inputLetter = (char) (inputLocation[0] + 65);
		return inputLetter + "" + (inputLocation[1] + 1) + "";
	}
	
	
	
	public String toString(){
		return fullEquation;
	}
	
	public static boolean isOperator(String input){
		if(input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/'){
			return true;
		}
		return false;
	}
	
	public static boolean isNumber(String input){
		try{
			Double.parseDouble(input);
			return true;
		}catch( java.lang.NumberFormatException e){
			return false;
		}
	}
}
