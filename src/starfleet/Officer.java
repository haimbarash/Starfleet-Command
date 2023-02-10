package starfleet;

public class Officer extends CrewWoman{
	private OfficerRank officerRank;
		
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age,yearsInService,name);
		this.officerRank = rank;
	}
	
	public OfficerRank getRank() {
		return this.officerRank;
		
	}
	
	
}
