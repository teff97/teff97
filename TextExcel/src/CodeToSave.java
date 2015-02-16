
public class CodeToSave {

	/*
	 * if(inputArray[2].charAt(0) < 47 && inputArray[2].charAt(0) > 58 && inputArray[4].charAt(0) < 47 && inputArray[4].charAt(0) > 58){
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
		
	 * public static void sortDescending(String input){
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
		
		//arrange by type so that you don't sort across type
		for(int idx = startLocation[1]; idx < endLocation[1];idx++){
			if(cells[startLocation[0]][idx].typeInCell != cells[startLocation[0]][idx+1].typeInCell){
				Cell tmp;
				for (int idx2 = idx + 1; idx2 < (endLocation[1]-startLocation[1]); idx2++) {
					if (cells[startLocation[0]][idx2].typeInCell == cells[startLocation[0]][idx].typeInCell){
						tmp = cells[startLocation[0]][idx+1];
						cells[startLocation[0]][idx+1] = cells[startLocation[0]][idx2];
						cells[startLocation[0]][idx2] = tmp;
					}
				}
			}
		}
		
		//System.out.println(endLocation[1]);
		//System.out.println(startLocation[1]);
		
		//sort inside each type
		for(int idx = endLocation[1]; idx > startLocation[1];idx--){
			
				int candidateIdx = idx;
				int idx2;
				for (idx2 = idx - 1; idx2 >= startLocation[1]; idx2--) {
					//System.out.println(idx + "" + cells[startLocation[0]][idx].typeInCell);
					//System.out.println(idx2 + "" + cells[startLocation[0]][idx2].typeInCell);
					if(cells[startLocation[0]][idx].typeInCell == 1 && cells[startLocation[0]][idx2].typeInCell == 1){
						if((cells[startLocation[0]][candidateIdx].date).compare(cells[startLocation[0]][idx2].date) < 0){
							candidateIdx = idx2;
						}
					}else if(cells[startLocation[0]][idx].typeInCell == 2 && cells[startLocation[0]][idx2].typeInCell == 2){
						
					}else if(cells[startLocation[0]][idx].typeInCell == 5 && cells[startLocation[0]][idx2].typeInCell == 5){
						if(cells[startLocation[0]][candidateIdx].doubleNumSave < cells[startLocation[0]][idx2].doubleNumSave){
							candidateIdx = idx2;
						}
					}else{
						
					}
				}
				Cell tmp = cells[startLocation[0]][idx];
				cells[startLocation[0]][idx] = cells[startLocation[0]][candidateIdx];
				cells[startLocation[0]][candidateIdx] = tmp;
		}
	}
	 * 
	 * public static void sortAscending(String input){
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
		
		//arrange by type so that you don't sort across type
		for(int idx = startLocation[1]; idx < endLocation[1];idx++){
			if(cells[startLocation[0]][idx].typeInCell != cells[startLocation[0]][idx+1].typeInCell){
				Cell tmp;
				for (int idx2 = idx + 1; idx2 < (endLocation[1]-startLocation[1]); idx2++) {
					if (cells[startLocation[0]][idx2].typeInCell == cells[startLocation[0]][idx].typeInCell){
						tmp = cells[startLocation[0]][idx+1];
						cells[startLocation[0]][idx+1] = cells[startLocation[0]][idx2];
						cells[startLocation[0]][idx2] = tmp;
					}
				}
			}
		}
		
		//sort inside each type
		for(int idx = startLocation[1]; idx < endLocation[1];idx++){
				int candidateIdx = idx;
				int idx2;
				for (idx2 = idx + 1; idx2 <= (endLocation[1]-startLocation[1]); idx2++) {
					if(cells[startLocation[0]][idx].typeInCell == 1 && cells[startLocation[0]][idx2].typeInCell == 1){
						if((cells[startLocation[0]][candidateIdx].date).compare(cells[startLocation[0]][idx2].date) < 0){
							candidateIdx = idx2;
						}
					}else if(cells[startLocation[0]][idx].typeInCell == 2 && cells[startLocation[0]][idx2].typeInCell == 2){
						
					}else if(cells[startLocation[0]][idx].typeInCell == 5 && cells[startLocation[0]][idx2].typeInCell == 5){
						if(cells[startLocation[0]][candidateIdx].doubleNumSave < cells[startLocation[0]][idx2].doubleNumSave){
							candidateIdx = idx2;
						}
					}else{
						
					}
				}
				Cell tmp = cells[startLocation[0]][idx];
				cells[startLocation[0]][idx] = cells[startLocation[0]][candidateIdx];
				cells[startLocation[0]][candidateIdx] = tmp;
		}
	}*/
}
