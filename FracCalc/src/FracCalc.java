//Chris Barth
//Frac Clac 
//Due November 6, 2014
//I did not complete any extra credit work


//import Scanner
import java.util.*;

public class FracCalc {
		static int wholenum1 = 0;
		static int numerator1 = 0;
		static int denominator1 = 1;
		static int wholenum2 = 0;
		static int numerator2 = 0;
		static int denominator2 = 1;
		static int wholenumans;
		static int numeratorans;
		static int denominatorans = 1;
		static int wholenumtemp = 0;
		static int numeratortemp = 0;
		static int denominatortemp = 1;
		static String equation = "continue";
		static int len = 0;
		static int idx = 0;
		static int fraccount = 0;
		static int wholecount = 0;
		static int fraccount2 = 0;
		static int wholecount2 = 0;
		static int GCD = 1;
		static int a;
		static int b;

	public static void main (String[]args){
		
		Scanner scan = new Scanner(System.in);
		
		
		while(!equation.equalsIgnoreCase("Quit")){
			//ask for input
			System.out.println("Enter an equation or \"Quit\".");
			equation = scan.nextLine();
			
			//if user input is an equation
			if(equation.equalsIgnoreCase("Quit")){
				System.out.println("the answer to life's question is 42!");
			}else{
				//find length 
				equation = equation.trim();
				len = equation.length();
				
				//find operator
				for(idx=0; equation.charAt(idx) != ' ' && idx < len;){
					idx++;
				}

					idx++;
					//idx = operator 
						//find if there is a fraction before operator
						for(fraccount = 0; equation.charAt(fraccount) != '/' && fraccount < idx; fraccount++){
						}
		
						//find if there is a whole number
						for(wholecount = 0; equation.charAt(wholecount) != '_' && wholecount < idx; wholecount++){
						}
						
						//store whole number
						if(equation.charAt(wholecount) == '_'){
							wholenum1 = Integer.parseInt(equation.substring(0,wholecount));
						}else if(fraccount == idx){
							wholenum1 = Integer.parseInt(equation.substring(0, (idx-1)));
						}
		
						//store numerator
						if(equation.charAt(fraccount) == '/' && equation.charAt(wholecount) == '_' && equation.charAt(fraccount-1) != ' '){
							numerator1 = Integer.parseInt(equation.substring((wholecount+1), fraccount));
						}else if (equation.charAt(fraccount) == '/' && wholecount == idx && equation.charAt(fraccount-1) != ' '){
							numerator1 = Integer.parseInt(equation.substring(0, fraccount));
						}
		
						//store denominator
						if(equation.charAt(fraccount) == '/' && equation.charAt(fraccount-1) != ' '){
							denominator1 = Integer.parseInt(equation.substring((fraccount + 1), (idx-1)));
						}
		
						//find if there is a fraction After operator (fraccount2 = position of / or position of last char)
						for(fraccount2 = idx+1; equation.charAt(fraccount2) != '/' && fraccount2 < (len-1); fraccount2++){
						}
		
						//find if there is a whole number2 (wholecount2 = position of _ or position of last char)
						for(wholecount2 = idx+1; equation.charAt(wholecount2) != '_' && wholecount2 < (len-1); wholecount2++){
						}
		
						//store whole number2
						if(equation.charAt(wholecount2) == '_'){
							wholenum2 = Integer.parseInt(equation.substring((idx+1),wholecount2).trim());
						}else if(fraccount2 == (len-1) && fraccount2 != (len-1)){
							wholenum2 = 0;
						}else if(fraccount2 == (len-1)){
							wholenum2 = Integer.parseInt(equation.substring((idx+1), len).trim());
						}
		
						//store numerator2
						if(equation.charAt(fraccount2) == '/' && equation.charAt(wholecount2) == '_'){
							numerator2 = Integer.parseInt(equation.substring((wholecount2+1), fraccount2));
						}else if (equation.charAt(fraccount2) == '/' && wholecount2 == (len-1)){
							numerator2 = Integer.parseInt(equation.substring(idx+1, fraccount2).trim());
						}
		
						//store denominator2
						if(equation.charAt(fraccount2) == '/'){
							denominator2 = Integer.parseInt(equation.substring((fraccount2 + 1), len));
						}
						
						
						if(equation.charAt(idx)=='+'){
							//convert to improper fractions
							improperfrac(wholenum1, numerator1, denominator1);
							numerator1 = numeratortemp;
					
							improperfrac(wholenum2, numerator2, denominator2);
							numerator2 = numeratortemp;
					
							//to same denominator
							add(numerator1, denominator1, numerator2, denominator2);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
				
							//to mixed number
							mixedfrac(wholenumans, numeratorans, denominatorans);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
							
							if(wholenumans== 0 && numeratorans == 0){
								System.out.println(0);
							}else if(wholenumans == 0 && denominatorans > 0){
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0 && denominatorans > 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans > 0){
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0 && numeratorans < 0){
								denominatorans = denominatorans*-1;
								numeratorans = numeratorans * -1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}				
						}else if(equation.charAt(idx)=='-'){
							//convert to improper fractions
							improperfrac(wholenum1, numerator1, denominator1);
							numerator1 = numeratortemp;
					
							improperfrac(wholenum2, numerator2, denominator2);
							numerator2 = numeratortemp;
					
							//to same denominator
							subtract(numerator1, denominator1, numerator2, denominator2);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
				
							//to mixed number
							mixedfrac(wholenumans, numeratorans, denominatorans);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
							
							if(wholenumans== 0 && numeratorans == 0){
								System.out.println(0);
							}else if(wholenumans == 0 && denominatorans > 0){
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0 && denominatorans > 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans > 0){
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0 && numeratorans < 0){
								denominatorans = denominatorans*-1;
								numeratorans = numeratorans * -1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}
						}else if(equation.charAt(idx)=='*'){
							//convert to improper fraction
							improperfrac(wholenum1, numerator1, denominator1);
							numerator1 = numeratortemp;
							
							//convert to improper fraction
							improperfrac(wholenum2, numerator2, denominator2);
							numerator2 = numeratortemp;
							
							multiply(numerator1, denominator1, numerator2, denominator2);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
		
							mixedfrac(wholenumans, numeratorans, denominatorans);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
							
							if(wholenumans== 0 && numeratorans == 0){
								System.out.println(0);
							}else if(wholenumans == 0 && denominatorans > 0){
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0 && denominatorans > 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans > 0){
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0 && numeratorans < 0){
								denominatorans = denominatorans*-1;
								numeratorans = numeratorans * -1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}
						}else if(equation.charAt(idx)=='/'){
							//convert to improper fraction
							improperfrac(wholenum1, numerator1, denominator1);
							numerator1 = numeratortemp;
							
							//convert to improper fraction
							improperfrac(wholenum2, numerator2, denominator2);
							numerator2 = numeratortemp;
							
							divide(numerator1, denominator1, numerator2, denominator2);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
		
							mixedfrac(wholenumans, numeratorans, denominatorans);
							
							numeratorans = numeratortemp;
							denominatorans = denominatortemp;
							wholenumans = wholenumtemp;
							
							if(wholenumans== 0 && numeratorans == 0){
								System.out.println(0);
							}else if(wholenumans == 0 && denominatorans > 0){
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0 && denominatorans > 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans > 0){
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0 && numeratorans < 0){
								denominatorans = denominatorans*-1;
								numeratorans = numeratorans * -1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(wholenumans == 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(numeratorans + "/" + denominatorans);
							}else if(numeratorans == 0){
								System.out.println(wholenumans);
							}else if(wholenumans != 0 && numeratorans != 0 && denominatorans < 0){
								denominatorans = denominatorans*-1;
								System.out.println(wholenumans + "_" + numeratorans + "/" + denominatorans);
							}
						}
					
				
				
				 wholenum1 = 0;
				numerator1 = 0;
				denominator1 = 1;
				wholenum2 = 0;
				numerator2 = 0;
				denominator2 = 1;
				wholenumans = 0;
				numeratorans = 0;
				denominatorans = 1;
				len = 0;
				idx = 0;
				fraccount = 0;
				wholecount = 0;
				fraccount2 = 0;
				wholecount2 = 0;
				numeratortemp = 0;
				denominatortemp = 1;
				wholenumtemp = 0;
				//System.out.println("operator " + equation.charAt(idx) + "\nwholenum1 = " + wholenum1 + "\nnumerator1 = " + numerator1 + "\ndenominator1 = " + denominator1 + "\nwholenum2 = " + wholenum2 + "\nnumerator2 = " + numerator2 + "\ndenominator2 = " + denominator2);
			}
		}
		
		scan.close();
	}
	
	
	public static void improperfrac(int wholenum, int numerator, int denominator){
		if(wholenum < 0){
			numerator = wholenum*denominator - numerator;
		}else if(numerator < 0){
			numerator = wholenum*denominator*-1 + numerator;
		}else if(wholenum >= 0 && numerator > 0){
			numerator = wholenum*denominator + numerator;
		}else if(numerator == 0){
			numerator = wholenum * denominator;
		}
		
		numeratortemp = numerator;
	}
	
	public static void mixedfrac(int wholenum, int numerator, int denominator){		
		if(numerator < 0){
			wholenumtemp = numerator/denominator;
			if(wholenumtemp != 0){
				numeratortemp = (numerator % denominator) * -1;
			}else if(wholenumtemp == 0){
				numeratortemp = numerator % denominator;
			}
		}else if(numerator > 0){
			wholenumtemp = numerator/denominator;
			numeratortemp = numerator % denominator;
		}else if(numerator == wholenum){
			wholenumtemp = wholenum;
			numeratortemp = 0;
		}
		
		
	}
	
	public static void simplify(int numerator, int denominator){
		
		//System.out.println("numerator " + numerator);
		//System.out.println("denominator " + denominator);
		
		a = numerator;
		b = denominator;
		while(a != 0  && b != 0){
			a = a % b;
			
			if(a != 0  && b != 0){
					b = b % a;
					
				}
		}
		if (a == 0){
			GCD = b;
		}else if (b == 0){
			GCD = a;
		}

		if(GCD < 0){
			GCD = GCD * -1;
		}
			
		//System.out.println("GCD " + GCD);
		
		if(GCD != 1){
			if(numerator == 0){
				numeratortemp = 0;
			}else if(numerator < 0 && denominator > 0){
				numeratortemp = numerator/GCD;
				denominatortemp = denominator/GCD;
			}else if(numerator < 0 && denominator < 0){
				numeratortemp = (numerator/GCD) * -1;
				denominatortemp = (denominator/GCD) * -1;
			}else if(numerator > 0 && denominator < 0){
				numeratortemp = -1 * (numerator/GCD);
				denominatortemp = (denominator/GCD) * -1;
			}else if(numerator > 0 && denominator > 0){
				numeratortemp = numerator/GCD;
				denominatortemp = denominator/GCD;
			}
		}else{
			numeratortemp = numerator;
			denominatortemp = denominator;
		}
		
		//System.out.println("numerator " + numeratortemp);
		//System.out.println("denominator " + denominatortemp);
	}
	
	public static void add(int numerator1, int denominator1, int numerator2, int denominator2){
		numerator1 = numerator1*denominator2;
		numerator2 = numerator2*denominator1;
		denominator1 = denominator1*denominator2;
		
		int numeratorans = numerator1 + numerator2;
		
		simplify(numeratorans, denominator1);
	}
	
	public static void subtract(int numerator1, int denominator1, int numerator2, int denominator2){
		numerator1 = numerator1*denominator2;
		numerator2 = numerator2*denominator1;
		denominator1 = denominator1*denominator2;

		int numeratorans = numerator1 - numerator2;
		
		simplify(numeratorans, denominator1);
	}
	
	public static void multiply(int numerator1, int denominator1, int numerator2, int denominator2){
		
		int numeratorans = numerator1 * numerator2;
		int denominatorans = denominator1 * denominator2;
		
		simplify(numeratorans, denominatorans);
	}
	
	public static void divide(int numerator1, int denominator1, int numerator2, int denominator2){
		
		int numeratorans = numerator1 * denominator2;
		int denominatorans = denominator1 * numerator2;
		
		simplify(numeratorans, denominatorans);
	}
	
	public static void print(){
		if(wholenumans == 0){
			System.out.println(numeratorans + "/" + denominator1);
		}else if(numeratorans == 0){
			System.out.println(wholenumans);
		}else if(wholenumans != 0 && numeratorans != 0){
			System.out.println(wholenumans + "_" + numeratorans + "/" + denominator1);
		}
	}
}
