package starfleet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	private static int numberOfStealthEngines;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numberOfStealthEngines++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon ("Laser Cannons",10,100)));
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		//StealthCruiser annualMaintenanceCost = BASIC_MAINTENANCE_COST_FIGHTER + weaponTotalCosts
		//+ round_down(1000*MaximalSpeed) + 50*numberOfStealthEnginesInFleet
		return super.getAnnualMaintenanceCost() + numberOfStealthEngines*50;
	}

	
}
