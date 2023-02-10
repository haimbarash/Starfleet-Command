package starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {
	private final int BASIC_MAINTENANCE_COST_COLONIAL_VIPER=4000;
	
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	@Override
	public int getAnnualMaintenanceCost() {
		//ColonialViper annualMaintenanceCost = BASIC_MAINTENANCE_COST_COLONIAL_VIPER + weaponTotalCosts + round_down(1000*MaximalSpeed) + 500*numberOfCrewMembers
		return BASIC_MAINTENANCE_COST_COLONIAL_VIPER + this.getWeaponCosts() +((int) Math.floor(500*this.getMaximalSpeed())) + 500*getCrewMembers().size();
	}

}
