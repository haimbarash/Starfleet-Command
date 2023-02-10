package starfleet;

import java.util.Set;

public class TransportShip extends MyAbstractSpaceship{
	private int cargoCapacity;
	private int passengerCapacity;
	private final int BASIC_MAINTENANCE_COST_TRANSPORTSHIP=3000;

	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;
	}
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		//TransportShip annualMaintenanceCost = BASIC_MAINTENANCE_COST_TRANSPORTSHIP + 5*cargoCapacity + 3*passengerCapacity
		return BASIC_MAINTENANCE_COST_TRANSPORTSHIP+(5*this.cargoCapacity)+(3*this.passengerCapacity);
	}
	
	@Override
	 public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString()).append("\n");
		str.append("\tAnnualMaintenanceCost=").append(getAnnualMaintenanceCost());
		str.append("\n\tCargoCapacity=").append(this.cargoCapacity);
		str.append("\n\tPassengerCapacity=").append(this.passengerCapacity);
		return str.toString();		
	}

}
