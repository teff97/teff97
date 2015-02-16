
public class Cell {

	Date date = new Date(0, 0, 0);
	Equation equation;
	String wordSave;
	String wordPrint;
	double doubleNumPrint; //truncated
	double doubleNumSave;
	int typeInCell;
	boolean isEquation = false;
	//1 is date, 2 is String of words, 3 is integer number, 
	//5 is decimal number, 6 is a double that is too big(use integerNumPrint)
	
	public Cell(Equation e){
		equation = e;
		typeInCell = 5;
		isEquation = true;
	}
	
	public Cell(Date d){
		date.year = d.year;
		date.day = d.day;
		date.month = d.month;
		typeInCell = 1;
	}
	
	public Cell(String s){
		wordSave = s;
		if(s.length() > 11){
			wordPrint = s.substring(0, 11);
		}else{
			wordPrint = s;
		}
		typeInCell = 2;
	}
	
	public Cell(String equationinput, int a){
		equation = new Equation(equationinput);
		typeInCell = a;
	}
	
	public Cell(double d){
		doubleNumSave = d;
		typeInCell = 5;
		String s = doubleNumSave + "";
		if(s.length() >= 10){
			doubleNumPrint = Double.parseDouble(s.substring(0, 11));
		}else{
			doubleNumPrint = d;
		}
	}
	
	public int compareCell(Cell cell2){
		if(typeInCell == cell2.typeInCell){
			if(typeInCell == 1){
				return date.compare(cell2.date);
			}else if(typeInCell == 2){
				return 1;
			}else if(typeInCell == 5){
				if(doubleNumSave < cell2.doubleNumSave){
					return -1;
				}else if(doubleNumSave > cell2.doubleNumSave){
					return 1;
				}else{
					return 0;
				}
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

}
