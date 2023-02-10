package starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends MyAbstractSpaceship{
	private List<Weapon> fighterWeapon;
	private final int BASIC_MAINTENANCE_COST_FIGHTER=2500;
	private int weaponTotalFirePower;
	private int weaponTotalCosts;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.fighterWeapon=weapons;
		for(Weapon weapon : fighterWeapon) {
			weaponTotalFirePower += weapon.getFirePower(); // Sums up fire power
			weaponTotalCosts += weapon.getAnnualMaintenanceCost(); // Sums up weapon maintenance cost
			
		}
	}
	

	public List<Weapon> getWeapon() {
		return this.fighterWeapon;
	}
	
	@Override
	public int getFirePower() {
		return (super.getFirePower() + this.weaponTotalFirePower);
		
	}
	
	protected int getWeaponCosts() {
		return weaponTotalCosts;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		//Fighter annualMaintenanceCost = BASIC_MAINTENANCE_COST_FIGHTER + weaponTotalCosts + round_down(1000*MaximalSpeed)
		return BASIC_MAINTENANCE_COST_FIGHTER + weaponTotalCosts +((int) Math.floor(1000*getMaximalSpeed()));
	}
	@Override
	 public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString()).append("\n");
		str.append("\tAnnualMaintenanceCost=").append(getAnnualMaintenanceCost());
		str.append("\n\tWeaponArray=").append(this.fighterWeapon);
		return str.toString();		
	}

	
	
}
