package starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship>{
	/* @pre: Spaceship != null 
	 * @return: A unique String represents the name of the spaceship*/
	public String getName();
	
	/* @pre: Spaceship != null 
	 * @return: The manufacture year of the spaceship*/
	public int getCommissionYear();
	
	/* @pre: Spaceship != null 
	 * @return: Maximum speed (fraction between 0 and 10).*/
	public float getMaximalSpeed();
	
	/* @pre: Spaceship != null 
	 * @return: Sum of fire-power of all installed weapons in the spaceship ( fire-power units)*/
	public int getFirePower();
	
	/* @pre: Spaceship != null 
	 * @return: The crew members in the Spaceship*/
	public Set<? extends CrewMember> getCrewMembers();
	
	/* @pre: Spaceship != null 
	 * @return: Total annual maintenance cost of the Spaceship*/
	public int getAnnualMaintenanceCost();

}
