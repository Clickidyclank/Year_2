package lab_2;

public class mainTest {
	public static void main(String[] args) {
	String[] players= {"Pakie Bonner", "Seamus Coleman", "Robbie Keane"};
	Team team1 = new Team("MyVeryBestIrish","Red","Cork");
	team1.setPlayers(players);
	
	players[0]="Messy";
	players[1]="Ronaldo";
	players[2]="Maradonna";
	
	Team team2 = new Team ("MyVeryBestWorld","Blue","Dublin");
	team2.setPlayers(players);
	
	
	System.out.println(team1);
	System.out.println(team2);
	
	
	}
}
