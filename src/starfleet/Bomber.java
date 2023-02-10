package starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter{
	private int numberOfTechnicians;
	private final int BASIC_MAINTENANCE_COST_BOMBER=5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians=numberOfTechnicians;
	}
	
	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}
	
	@Override
	protected int getWeaponCosts() {
		// Every Bomber spaceship has 0-5 technicians. for every technician in the spaceship, there is a weapon cost reduction of 10%.
		// Weapon costs in boomer = (weapon maintenance cost)*(1 - numberOfTechnicians/10)
		if (numberOfTechnicians>0)
			return Math.round(super.getWeaponCosts()*(1 - (float) numberOfTechnicians/10));
		return super.getWeaponCosts();
		
	}

	@Override
	public int getAnnualMaintenanceCost() {
		//Bomber annualMaintenanceCost = BASIC_MAINTENANCE_COST_BOMBER + weaponTotalCosts
		return BASIC_MAINTENANCE_COST_BOMBER + this.getWeaponCosts();
	}
	@Override
	 public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString()).append("\n");
		str.append("\tNumberOfTechnicians=").append(numberOfTechnicians);
		return str.toString();		
	}


}
