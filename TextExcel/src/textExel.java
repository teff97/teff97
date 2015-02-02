//import Scanner
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;

public class textExel {

	final static int numOfRows = 13;
	final static int numOfColumns = 15;
	static int inputLocation[] = new int[2];
	//[columns][Rows] like A6
	static Cell cells[][] = new Cell[numOfColumns][numOfRows];

	
	public static void main (String[]args){
		
		Scanner scan = new Scanner(System.in);
		String input = "";
		
		do{
		printArray();
		System.out.println("What do you want to do?");
		input = scan.nextLine();
		
		if(input.equalsIgnoreCase("quit")){
		}else if(input.equalsIgnoreCase("clear")){
			clearAll();
		}else if(ifClear(input)){
			clear(input);
		}else if(ifExport(input)){
			export(input);
		}else if(ifImport(input)){
			importFile(input);
		}else if(ifSorta(input)){
			sortAscending(input);
		}else if(ifSortd(input)){
			sortDescending(input);
		}else if(ifEquation(input)){
			Equation(input);
			
		}else{
			try{
			parseInput(input);
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Wrong input");
			}
		}
		
		}while(!input.equalsIgnoreCase("quit"));
		
		scan.close();
	}
	
	//parse input for location then determine if the input is a date, int, String, or double
	//1 is date, 2 is String of words, 3 is integer number, 
	//4 is an integer that is too big, 5 is decimal number, 
	//6 is a double that is too big(use integerNumPrint)
	public static void parseInput(String input){
		String inputArray[] = input.split(" ");
		if(inputArray.length != 1){
			parseLocation(inputArray[0]);
	
			//if statements determine if is a date double int or string
			//inputArray[2] should be the thing that they are storing
			if(inputArray.length == 3 && isDate(inputArray[2])) {
				Date date = new Date(inputArray[2]);
				cells[inputLocation[0]][inputLocation[1]] = new Cell(date);
			}else if(inputArray.length == 3 && isDouble(inputArray[2]) == true){
				cells[inputLocation[0]][inputLocation[1]] = new Cell(Double.parseDouble(inputArray[2]));
			}else if(inputArray.length >= 3 && isStringStart(inputArray[2]) && isStringEnd(inputArray[inputArray.length-1])){
				String passString = "";
				for(int idx = 2;idx < inputArray.length; idx++){
					passString = passString + inputArray[idx];
				}
				cells[inputLocation[0]][inputLocation[1]] = new Cell(passString);
			}else if(inputArray.length == 5 && !(isStringStart(inputArray[2]) && isStringEnd(inputArray[inputArray.length-1]))){
				cells[inputLocation[0]][inputLocation[1]] = new Cell(input, 3);
			}else{
				cells[inputLocation[0]][inputLocation[1]] = new Cell("ERROR");
			}
		}
	}
	
	public static boolean isDate(String date){
		int counter = 0;
		for(int idx = 0; idx < date.length(); idx++){
			if(date.charAt(idx) == '/' || date.charAt(idx) == '-'){
				counter++;
			}
		}
		
		if(counter == 2){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isDouble(String doub){
		
		if((doub.charAt(0) < 48 || doub.charAt(0) > 57) && doub.charAt(0) != '-' && doub.charAt(0) != '.'){
			return false;
		}
		
		int counter = 0;
		for(int idx = 1; idx < doub.length(); idx++){
			if((doub.charAt(idx) < 48 || doub.charAt(idx) > 57) && doub.charAt(idx) != '.'){
				return false;
			}else if(doub.charAt(idx) == '.'){
				//(doub.charAt(idx) >= 48 && doub.charAt(idx) <= 57)
				counter++;
			}
		}
		
		if(counter > 1){
			return false;
		}
		
		return true;
	}
	
	public static boolean isStringStart(String s){
		
		if(s.charAt(0) == '"'){
			return true;
		}
		return false;
	}
//have to make a second b/c if String "asdfa asfdasd" then the first the split function would seperate them
	public static boolean isStringEnd(String s){
		
		if(s.charAt(s.length()-1) == '"'){
			return true;
		}
		return false;
	}
	
	public static void printLine(){
		for(int idx = 0; idx < numOfColumns+1; idx ++){
			System.out.print("-----------");
		}
		System.out.println("-");
	}
	
	public static void setColums(){
		System.out.print("|     ");
		for(int idx = 0; idx < numOfColumns; idx ++){
			System.out.print("     |    " + (char)(idx + 65));
		}
		System.out.println("     |");
	}
	
	//1 is date, 2 is String of words, 3 is integer number, 
	//5 is decimal number, 6 is a double that is too big(use integerNumPrint)
	public static void printArray(){
		printLine();
		setColums();
		printLine();
		for (int row = 0; row < numOfRows; row++){
			if(row < 9){
				System.out.print("||    " + (row+1) + "   |");
			}else{
				System.out.print("||   " + (row+1) + "   |");
			}
			for(int col = 0; col < numOfColumns; col++){
				if(cells[col][row] != null && (cells[col][row].typeInCell == 1 || cells[col][row].typeInCell == 2 || cells[col][row].typeInCell == 3 || cells[col][row].typeInCell == 5)){
					if(cells[col][row].typeInCell == 1){
						String print = "|" + cells[col][row].date.toStringWithSlash();
						while(print.length() < 11){
							print += " ";
						}
						System.out.print(print);
					}else if(cells[col][row].typeInCell == 2){
						String print = "|" + cells[col][row].wordPrint;
						while(print.length() < 11){
							print += " ";
						}
						System.out.print(print);
					}else if(cells[col][row].typeInCell == 5){
						String print = "|" + cells[col][row].doubleNumPrint;
						while(print.length() < 11){
							print += " ";
						}
						System.out.print(print);
					}else{
						String print = "|";
						while(print.length() < 11){
							print += " ";
						}
						System.out.print(print);
					}
				}else{
					String print = "|";
					while(print.length() < 11){
						print += " ";
					}
					System.out.print(print);
				}
			}
			System.out.println("|");
			printLine();
		}
	}
	
	public static void clear(String input){
		parseLocationClear(input);
		cells[inputLocation[0]][inputLocation[1]] = null;
	}
	
	public static void parseLocation(String input){
		try{
		inputLocation[0] = (int) (input.charAt(0)-65);
		inputLocation[1] = Integer.parseInt(input.substring(1))-1;
		}catch(NumberFormatException e){
			System.out.println("ERROR");
			//String []args = {};
			//textExel.main(args);
		}
	}
	
	public static boolean ifClear(String input){
		String inputArray[] = input.split(" ");
		if(inputArray.length == 2 && inputArray[0].equalsIgnoreCase("clear")){
			return true;
		}
		return false;
	}
	
	public static void parseLocationClear(String input){
		String inputArray[] = input.split(" ");
		inputLocation[0] = (int) (inputArray[1].charAt(0)-65);
		inputLocation[1] = Integer.parseInt(inputArray[1].substring(1))-1;
	}
	
	public static void clearAll(){
		for (int row = 0; row < numOfRows; row++){
			for(int col = 0; col < numOfColumns; col++){
				cells[col][row] = null;
			}
		}
	}	
	
	public static boolean ifExport(String s){
		String sArray[] = s.split(" ");
		if(sArray[0].equalsIgnoreCase("export")){
			return true;
		}else{
			return false;
		}
	}
	
	public static void export(String input){
		String inputArray[] = input.split(" ");
		File f = new File(inputArray[1]);
		PrintStream p;
		try{
			p = new PrintStream(f);
		}catch(FileNotFoundException e){
			System.out.println("ERROR");
			return;
		}
		for(int idx = 0; idx < numOfColumns+1; idx ++){
			p.print("-----------");
		}
		p.println("-");
		p.print("|     ");
		for(int idx = 0; idx < numOfColumns; idx ++){
			p.print("     |    " + (char)(idx + 65));
		}
		p.println("     |");
		for(int idx = 0; idx < numOfColumns+1; idx ++){
			p.print("-----------");
		}
		p.println("-");
		for (int row = 0; row < numOfRows; row++){
			if(row < 9){
				p.print("||    " + (row+1) + "   |");
			}else{
				p.print("||   " + (row+1) + "   |");
			}
			for(int col = 0; col < numOfColumns; col++){
				if(cells[col][row] != null && (cells[col][row].typeInCell == 1 || cells[col][row].typeInCell == 2 || cells[col][row].typeInCell == 3 || cells[col][row].typeInCell == 5)){
					if(cells[col][row].typeInCell == 1){
						String print = "|" + cells[col][row].date.toStringWithSlash();
						while(print.length() < 11){
							print += " ";
						}
						p.print(print);
					}else if(cells[col][row].typeInCell == 2){
						String print = "|" + cells[col][row].wordPrint;
						while(print.length() < 11){
							print += " ";
						}
						p.print(print);
					}else if(cells[col][row].typeInCell == 5){
						String print = "|" + cells[col][row].doubleNumPrint;
						while(print.length() < 11){
							print += " ";
						}
						p.print(print);
					}else{
						String print = "|";
						while(print.length() < 11){
							print += " ";
						}
						p.print(print);
					}
				}else{
					String print = "|";
					while(print.length() < 11){
						print += " ";
					}
					p.print(print);
				}
			}
			p.println("|");
			for(int idx = 0; idx < numOfColumns+1; idx ++){
				p.print("-----------");
			}
			p.println("-");
		}
		p.close();
	}
	
	public static boolean ifImport(String s){
		String sArray[] = s.split(" ");
		if(sArray[0].equalsIgnoreCase("import")){
			return true;
		}else{
			return false;
		}
	}
	
	public static void importFile(String inputs){
		String inputArray[] = inputs.split(" ");
		File f = new File(inputArray[1]);
		Scanner input;
		try{
			input = new Scanner(f);
		}catch(FileNotFoundException e){
			System.out.println("ERROR");
			return;
		}
		int rowCounter = 0;
		while(input.hasNext()){
			String importedLine = input.nextLine();
			int lineCounter = 0;
			String newInput;
			if(!importedLine.substring(0, 12).equals("------------")  && !importedLine.substring(0, 12).equals("|          |")){
				for(int idx = 0; idx < importedLine.length();idx++){
					if(importedLine.charAt(idx) == '|'){
						lineCounter++;
					}else if(importedLine.charAt(idx) != ' '){
						if(lineCounter == 2){
							
						}else{
							int idx2;
							for(idx2 = idx;idx2 < importedLine.length() && importedLine.charAt(idx2) != ' '; idx2++){
							}
							newInput = ((char) ((lineCounter-3)+64)) + "" + (rowCounter+1) + " = " + importedLine.substring(idx, idx2);
							//System.out.println(importedLine.substring(idx, idx2));
							//System.out.println(newInput);
							parseInput(newInput);
							idx = idx2;
						}
					}
				}
				rowCounter++;
			}
		}
		
		
		input.close();
	}
	
	public static boolean ifSorta(String input){
		String inputArray[] = input.split(" ");
		if(inputArray[0].equalsIgnoreCase("sorta")){
			return true;
		}
		return false;
	}
	
	public static void sortAscending(String input){
		String inputArray[] = input.split(" ");
		//input should be sorta A1 to A5
		parseLocation(inputArray[1]);
		int startLocation [] = new int[2];
		startLocation[0] = inputLocation[0];
		startLocation[1] = inputLocation[1];
		parseLocation(inputArray[3]);
		int endLocation [] = new int[2];
		endLocation[0] = inputLocation[0];
		endLocation[1] = inputLocation[1];
		
		//find the number of cells
		int numOfCells = (endLocation[0]-startLocation[0])*(endLocation[1]-startLocation[1]);
		
		//Create one dementional array that has the length of all cells selected
		Cell sortArray[] = new Cell[numOfCells];
		
		int sortArrayLocation = 0;
		
		for(int idx = startLocation[0];idx <= endLocation[0];idx++){
			for(int idx2 = startLocation[1];idx2 <= endLocation[1];idx2++){
				sortArray[sortArrayLocation] = cells[idx][idx2];
				sortArrayLocation++;
			}
		}
		
		//arrange by type so that you don't sort across type
			for(int idx = 0; idx < sortArray.length; idx++){
				if(sortArray[idx].typeInCell != sortArray[idx+1].typeInCell){
					Cell tmp;
					for (int idx2 = idx + 1; idx2 < sortArray.length; idx2++) {
						if (sortArray[idx2].typeInCell == sortArray[idx].typeInCell){
							tmp = sortArray[idx+1];
							sortArray[idx+1] = sortArray[idx2];
							sortArray[idx2] = tmp;
						}
					}
				}
			}
		
		//sort in ascending order
			for(int idx = 0; idx < sortArray.length;idx++){
				int candidateIdx = idx;
				int idx2;
				for (idx2 = idx + 1; idx2 < sortArray.length; idx2++) {
					if(sortArray[idx].typeInCell == 1 && sortArray[idx2].typeInCell == 1){
						if((sortArray[candidateIdx].date).compare(sortArray[idx2].date) < 0){
							candidateIdx = idx2;
						}
					}else if(sortArray[idx].typeInCell == 2 && sortArray[idx2].typeInCell == 2){
						
					}else if(sortArray[idx].typeInCell == 5 && sortArray[idx2].typeInCell == 5){
						if(sortArray[candidateIdx].doubleNumSave < sortArray[idx2].doubleNumSave){
							candidateIdx = idx2;
						}
					}else{
						
					}
				}
				Cell tmp = sortArray[idx];
				sortArray[idx] = sortArray[candidateIdx];
				sortArray[candidateIdx] = tmp;
		}
		
		//put the values into the spreadsheet
			sortArrayLocation = 0;
			
			for(int idx = startLocation[0];idx <= endLocation[0];idx++){
				for(int idx2 = startLocation[1];idx2 <= endLocation[1];idx2++){
					cells[idx][idx2] = sortArray[sortArrayLocation];
					sortArrayLocation++;
				}
			}
	}
	
	public static boolean ifSortd(String input){
		String inputArray[] = input.split(" ");
		if(inputArray[0].equalsIgnoreCase("sortd")){
			return true;
		}
		return false;
	}
	
	public static void sortDescending(String input){
		String inputArray[] = input.split(" ");
		//input should be sortd A1 to A5
		parseLocation(inputArray[1]);
		int startLocation [] = new int[2];
		startLocation[0] = inputLocation[0];
		startLocation[1] = inputLocation[1];
		parseLocation(inputArray[3]);
		int endLocation [] = new int[2];
		endLocation[0] = inputLocation[0];
		endLocation[1] = inputLocation[1];
		
		//find the number of cells
		int numOfCells = (endLocation[0]-startLocation[0])*(endLocation[1]-startLocation[1]);
		
		//Create one dementional array that has the length of all cells selected
		Cell sortArray[] = new Cell[numOfCells];
		
		int sortArrayLocation = 0;
		
		for(int idx = startLocation[0];idx <= endLocation[0];idx++){
			for(int idx2 = startLocation[1];idx2 <= endLocation[1];idx2++){
				sortArray[sortArrayLocation] = cells[idx][idx2];
				sortArrayLocation++;
			}
		}
		
		//arrange by type so that you don't sort across type
			for(int idx = 0; idx < sortArray.length; idx++){
				if(sortArray[idx].typeInCell != sortArray[idx+1].typeInCell){
					Cell tmp;
					for (int idx2 = idx + 1; idx2 < sortArray.length; idx2++) {
						if (sortArray[idx2].typeInCell == sortArray[idx].typeInCell){
							tmp = sortArray[idx+1];
							sortArray[idx+1] = sortArray[idx2];
							sortArray[idx2] = tmp;
						}
					}
				}
			}
		
		//sort in descending order
			for(int idx = 0; idx < sortArray.length;idx++){
				int candidateIdx = idx;
				int idx2;
				for (idx2 = idx + 1; idx2 < sortArray.length; idx2++) {
					if(sortArray[idx].typeInCell == 1 && sortArray[idx2].typeInCell == 1){
						if((sortArray[candidateIdx].date).compare(sortArray[idx2].date) > 0){
							candidateIdx = idx2;
						}
					}else if(sortArray[idx].typeInCell == 2 && sortArray[idx2].typeInCell == 2){
						
					}else if(sortArray[idx].typeInCell == 5 && sortArray[idx2].typeInCell == 5){
						if(sortArray[candidateIdx].doubleNumSave > sortArray[idx2].doubleNumSave){
							candidateIdx = idx2;
						}
					}else{
						
					}
				}
				Cell tmp = sortArray[idx];
				sortArray[idx] = sortArray[candidateIdx];
				sortArray[candidateIdx] = tmp;
		}
		
		//put the values into the spreadsheet
			sortArrayLocation = 0;
			
			for(int idx = startLocation[0];idx <= endLocation[0];idx++){
				for(int idx2 = startLocation[1];idx2 <= endLocation[1];idx2++){
					cells[idx][idx2] = sortArray[sortArrayLocation];
					sortArrayLocation++;
				}
			}
	}
	
	public static boolean ifEquation(String input){
		String inputArray[] = input.split(" ");
		if(inputArray.length < 5){
			//System.out.println("false1");
			return false;
		}
	
		//System.out.println("true");
		return true;
	}
	
	public static void Equation(String input){
		String inputArray[] = input.split(" ");
		if(inputArray[2].charAt(0) < 47 && inputArray[2].charAt(0) > 58 && inputArray[4].charAt(0) < 47 && inputArray[4].charAt(0) > 58){
			Equation e = new Equation(input);
			cells [e.storeLocation[0]][e.storeLocation[1]] = new Cell(e);
			cells [e.storeLocation[0]][e.storeLocation[1]].doubleNumSave = e.evaluate(cells);
			cells [e.storeLocation[0]][e.storeLocation[1]].doubleNumPrint = e.evaluate(cells);
			//System.out.println(cells [e.storeLocation[0]][e.storeLocation[1]].doubleNumPrint);
		}else if(inputArray[2].charAt(0) > 47 && inputArray[2].charAt(0) < 58 && inputArray[4].charAt(0) > 47 && inputArray[4].charAt(0) < 58){
			parseLocation(inputArray[0]);
			char operation = inputArray[3].charAt(0);
			double ans = 0.0;
			if(operation == '+'){
				ans = Double.parseDouble(inputArray[2]) + Double.parseDouble(inputArray[4]);
			}else if(operation == '-'){
				ans = Double.parseDouble(inputArray[2]) - Double.parseDouble(inputArray[4]);
			}else if(operation == '*'){
				ans = Double.parseDouble(inputArray[2]) * Double.parseDouble(inputArray[4]);
			}else if(operation == '/'){
				ans = Double.parseDouble(inputArray[2]) / Double.parseDouble(inputArray[4]);
			}
			cells [inputLocation[0]][inputLocation[1]] = new Cell(ans);
		}
	}
	
}
