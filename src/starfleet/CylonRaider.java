package starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{
	private final int BASIC_MAINTENANCE_COST_CYLON_RAIDER=3500;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		//CylonRaider annualMaintenanceCost = BASIC_MAINTENANCE_COST_CYLON_RAIDER + weaponTotalCosts + round_down(1200*MaximalSpeed)+ 500*numberOfCrewMembers
		return BASIC_MAINTENANCE_COST_CYLON_RAIDER + this.getWeaponCosts() +((int) Math.floor(1200*this.getMaximalSpeed())) + 500*getCrewMembers().size();
	}

}
