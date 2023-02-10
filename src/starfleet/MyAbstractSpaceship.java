package starfleet;

import java.util.Set;

public abstract class MyAbstractSpaceship extends MyAbstractSpace implements Spaceship{
	private int commissionYear;
	private float maxSpeed ;
	private int firePower;
	private Set<? extends CrewMember> crewMembers;

	public MyAbstractSpaceship(String name, int year, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		super(name);
		this.commissionYear=year;
		this.maxSpeed=maximalSpeed;
		this.crewMembers=crewMembers;
		this.firePower = 10;
	}
	
	public int getCommissionYear() {
		return this.commissionYear;
	}

	public float getMaximalSpeed() {
		return this.maxSpeed;
	}
	
	public int getFirePower() {
		return this.firePower;
	}
	

	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	@Override
	 public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.getClass().getSimpleName()).append("\n");
		str.append("\tName=").append(getName());
		str.append("\n\tCommissionYear=").append(commissionYear);
		str.append("\n\tMaximalSpeed=").append(maxSpeed);
		str.append("\n\tFirePower=").append(getFirePower());
		str.append("\n\tCrewMembers=").append(crewMembers.size());
		return str.toString();		
	}
	@Override
	public int compareTo(Spaceship other) {
		/**
		 * Compare Spaceship objects in descending order by:
		 * fire power, and then in descending order by commission year, and finally in ascending order by
		 * name
		 */
		if (this.getFirePower() != other.getFirePower())
			return ((Integer) (other.getFirePower())).compareTo((Integer) this.getFirePower());
		if (this.getCommissionYear() != other.getCommissionYear())
			return ((Integer) (other.getCommissionYear())).compareTo((Integer) this.getCommissionYear());
		return this.getName().compareTo(other.getName());
	}
}
