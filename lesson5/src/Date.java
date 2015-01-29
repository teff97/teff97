// Seattle Prep CS class
// 12/16/2014
//
public class Date {
	// data fields
	private int month;
	private int day;
	private int year;
	private int printFormat; // 1 = slashes, 2 = dashes, 3 = long form

	// constructor from 3 integers
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
		printFormat = 1;
	}

	// constructor from string
	public Date(String s) {
		String[] w = s.split("/");
		month = Integer.parseInt(w[0]);
		day = Integer.parseInt(w[1]);
		year = Integer.parseInt(w[2]);
		printFormat = 1;
	}

	// year accessor
	public int getYear() {
		return year;
	}

	// convert to string, with slash
	private String toStringWithSlash() {
		return month + "/" + day + "/" + year;
	}

	// convert to string, with dash
	private String toStringWithDash() {
		return month + "-" + day + "-" + year;
	}

	// convert to string, long form
	private String toStringLongForm() {
		String[] months = { "January", "February", "March", "April", "May",
"June", "July", "August", "September",
"October", "November", "December" };

		// set up month name, day
		String s = months[month - 1] + " " + day;

		// add proper suffix to day
		if (day == 1 || day == 21 || day == 31) {
			s = s + "st";
		} else if (day == 2 || day == 22) {
			s = s + "nd";
		} else if (day == 3 || day == 23) {
			s = s + "rd";
		} else {
			s = s + "th";
		}

		// add year
		s = s + ", " + year;

		return s;
	}

	// set to print with slash
	public void setPrintWithSlash() {
		printFormat = 1;
	}

	// set to print with dash
	public void setPrintWithDash() {
		printFormat = 2;
	}

	// set to print in long form
	public void setPrintLongForm() {
		printFormat = 3;
	}

	// convert to String based on setting
	public String toString() {
		if (printFormat == 1) {
			return toStringWithSlash();
		} else if (printFormat == 2) {
			return toStringWithDash();
		} else {
			return toStringLongForm();
		}
	}

	// date comparison
	public int compare(Date d) {
		// check year
		if (year < d.year)
			return -1;
		else if (year > d.year)
			return 1;

		// equal years, check month
		if (month < d.month)
			return -1;
		else if (month > d.month)
			return 1;

		// equal month, check day
		if (day < d.day)
			return -1;
		else if (day > d.day)
			return 1;
		else
			return 0;
	}
	
	
	//The stuff that I made
	public String toStringWithAbbreviation(){
		String Months[] = new String[12];
		Months[0] = "Jan";
		Months[1] = "Feb";
		Months[2] = "Mar";
		Months[3] = "Apr";
		Months[4] = "May";
		Months[5] = "June";
		Months[6] = "July";
		Months[7] = "Aug";
		Months[8] = "Sept";
		Months[9] = "Oct";
		Months[10] = "Nov";
		Months[11] = "Dec";
		
		return Months[(month-1)] + "-" + day + "-" + year;
	}
	
	public String toStringWithMonth(){
		String Months[] = new String[12];
		Months[0] = "January";
		Months[1] = "Febuary";
		Months[2] = "March";
		Months[3] = "April";
		Months[4] = "May";
		Months[5] = "June";
		Months[6] = "July";
		Months[7] = "August";
		Months[8] = "September";
		Months[9] = "October";
		Months[10] = "November";
		Months[11] = "December";
		
		if(day >=4 && day <=20){
			return Months[(month-1)] + " " + day + "th, " + year;
		}else if(day >=24 && day <=30){
			return Months[(month-1)] + " " + day + "th, " + year;
		}else if(day == 1 || day == 21 || day == 31){
			return Months[(month-1)] + " " + day + "st, " + year;
		}else if(day == 2 || day == 22){
			return Months[(month-1)] + " " + day + "nd, " + year;
		}else if(day == 3 || day == 23){
			return Months[(month-1)] + " " + day + "rd, " + year;
		}else{
			return "wrong";
		}
	}
	
	public void setPrintWithAbbreviation() {
		printFormat = 3;
	}
	
	public void setPrintWithMonth() {
		printFormat = 4;
	}

	// convert to String based on setting
	
}
