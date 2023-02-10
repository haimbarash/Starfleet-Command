package starfleet;

public class Cylon extends MyAbstractCrewMember {
	private int modelNumber;

	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(name, age, yearsInService);
		this.modelNumber = modelNumber;
	}
	
	public int getModelNumber() {
		return this.modelNumber;
	}

}
