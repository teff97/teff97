// Seattle Prep CS class
// 12/16/2014
//
public class MainProgram {

	// client for Person and Date classes
	public static void main(String[] args) {
		Player[] roster = { new Player("Rusell Wilson", "11/29/1988"),
			new Player("Marshawn Lynch", "4/22/1986"),
			new Player("Doug Baldwin", "9/21/1988"),
			new Player("Michael Bennett", "11/13/1985"),
			new Player("Clint Gresham", "8/24/1986"),
			new Player("Jermaine Kearse", "2/6/1990"),
			new Player("Richard Sherman", "3/30/1988"),
			new Player("Earl Thomas", "5/7/1989"),
			new Player("Bryan Walters", "11/4/1987"),
			new Player("Tharold Simon", "3/6/1991"), 
			new Player("Demaryius Thomas", "12/25/1987")};

		// print team, and various subsets
		printTeam(roster);
		printPlayersBornBefore1987(roster);
		printYougestPlayer(roster);
		printSecondYougestPlayer(roster);
		
		sort(roster);
		printTeam(roster);
		
		for(int idx = 1; idx <= roster.length; idx++){
			nthPlayer(roster, idx);
		}
		
	}

	// print all players in the set
	static void printTeam(Player[] r) {
		System.out.println("All players:");
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}

	// print players born before 1987
	static void printPlayersBornBefore1987(Player[] r) {
		System.out.println("\nPlayers Born Before 1987: ");
		Date bornBefore = new Date(1, 1, 1987);
		for (int i = 0; i < r.length; i++) {
			if (bornBefore.compare(r[i].getBirthday()) == 1){
				System.out.println(r[i]);
			}
		}
	}

	// print youngest player
	static void printYougestPlayer(Player[] r) {
		System.out.println("\nYougest Player");
		int positionOfPlayer = 0;
		for (int i = 1; i < r.length; i++) {
			if((r[i].getBirthday()).compare(r[positionOfPlayer].getBirthday()) == 1){
				positionOfPlayer = i;
			}
		}
		
		System.out.println(r[positionOfPlayer]);
		
	}

	// print second youngest player
	static void printSecondYougestPlayer(Player[] r) {
		System.out.println("\nSecond Yougest Player");
		int positionOfPlayer = 0;
		
		for (int i = 1; i < r.length; i++) {
			if((r[i].getBirthday()).compare(r[positionOfPlayer].getBirthday()) == 1){
				positionOfPlayer = i;
			}
		}
		
		int positionOfPlayer2;

		if(positionOfPlayer == 0){
			positionOfPlayer2 = 1;
		}else{
			positionOfPlayer2 = 0;
		}
		
		for (int i = 1; i < r.length; i++) {
			if((r[i].getBirthday()).compare(r[positionOfPlayer2].getBirthday()) == 1 && positionOfPlayer != i){
				positionOfPlayer2 = i;
			}
		}
		
		System.out.println(r[positionOfPlayer2]);

	}
	
	// mystery
	static void mystery(Player[] r, int startIdx) {
		// examine all players from startIdx to the end
		int candidateIdx = startIdx;
		for (int idx = startIdx + 1; idx < r.length; idx++) {
			if (r[idx].getBirthday().compare(r[candidateIdx].getBirthday()) > 0){
				candidateIdx = idx;
			}
		}
		
		// swap candidateIdx with startIdx
		Player tmp = r[startIdx];
		r[startIdx] = r[candidateIdx];
		r[candidateIdx] = tmp;
	}
	
	public static void sort(Player [] r){
		for(int idx = 0; idx < r.length; idx ++){
			mystery(r, idx);
		}
	}
	
	public static void nthPlayer(Player [] r, int n){
		Player temp [] = new Player[r.length];
		
		for(int idx = 0; idx < r.length; idx ++){
			temp[idx] = r[idx];
		}
		
		sort(temp);
		
		System.out.println("\nthe " + n + " Youngest Player:");
		System.out.println(temp[n-1]);
	}
}


