package starfleet;

public abstract class MyAbstractCrewMember extends MyAbstractSpace implements CrewMember{
	private int crewAge;
	private int crewYearsInService;
	
	public MyAbstractCrewMember(String name, int age, int yearsInService) {
		super(name);
		this.crewAge = age;
		this.crewYearsInService =  yearsInService;
	}
	
	@Override
	public int getAge() {
		return this.crewAge;
	}
	
	@Override
	public int getYearsInService() {
		return this.crewYearsInService;
	}
}
