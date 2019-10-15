package lab_2;

public class Team {
	private String name;
	private String jersey;
	private String location;
	private Player[] players;
	
	
	
	public Team(String name, String jersey, String location) {
		this.name = name;
		this.jersey = jersey;
		this.location = location;
		
		
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getJersey() {
		return jersey;
	}



	public void setJersey(String jersey) {
		this.jersey = jersey;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Player[] getPlayers() {
		
		return this.players;
	}



	public void setPlayers(String[] players) {
		Player[] temp = new Player[3];
		for(int i=0; i<players.length;i++) {
			temp[i] = new Player(players[i]);
			
		}
		this.players = temp;
	}
	
	public String toString() {
		
		String string = "Name of team : " + getName() +"\n" + "Color of jersey : "+getJersey()+"\nHome location of team : " + getLocation()+"\nPlayers in team : ";
		for (int i=0; i<3;i++) {
			string = string +(players[i].getName()) +" ";
		}
		return string;
		
	}
	public void pirnt () {
		System.out.println(this.name);
		System.out.println(this.jersey);
		System.out.println(this.location);
		System.out.println(this.players);
	}
}
