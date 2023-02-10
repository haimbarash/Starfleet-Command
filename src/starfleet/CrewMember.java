package starfleet;

public interface CrewMember {
	/* @pre: CrewMember != null 
	 * return a Unique String represents the name of the crew member*/
	public String getName();
	
	/* @pre: CrewMember != null 
	 * return the age of the crew member in earth years*/
	public int getAge();
	
	/* @pre: CrewMember != null 
	 * return the number of years in service of the crew member in earth years*/
	public int getYearsInService();

}
