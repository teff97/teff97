//import scanner
import java.util.Scanner;

public class Lab_10_28_14 {

	public static void main (String[]args){
		
		String cont = " ";
		Scanner scan = new Scanner(System.in);
		
		while(!cont.equals("quit")){
			
			System.out.println("would you like to continue? (Y/quit)");
			cont = scan.nextLine();
			cont = cont.toLowerCase();
			System.out.println("number 1: ");
			int first = scan.nextInt();
			System.out.println("number 2: ");
			int second = scan.nextInt();
			System.out.println("number 3: ");
			int third = scan.nextInt();
			scan.nextLine();
			
			int ans = maxNumber(first, second, third);
			
			System.out.println("The input was: \n" + first + "\n" + second + "\n" + third + "\nThe largest is " + ans);
			
		}
		scan.close();
	}
	
	
	public static int maxNumber(int first, int second, int third){
		int ans = 0;
		
		if(first > second && first >third){
			ans = first;
		}else if(second > first && second >third){
			ans = second;
		}else if(third > second && third > first){
			ans = third;
		}
		
		return ans;
	}
}
