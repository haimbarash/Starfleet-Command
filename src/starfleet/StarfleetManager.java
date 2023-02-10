package starfleet;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> spaceships = new ArrayList<> ();
		List<String> spaceshipsNames = new ArrayList<> ();
		for(Spaceship spaceship : fleet) {// new list of all the spaceships in the fleet
			spaceships.add(spaceship);
		}
		Collections.sort(spaceships);
		for(Spaceship spaceship : spaceships) {
			spaceshipsNames.add(spaceship.toString());
		}
		return spaceshipsNames;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> numberPerClass = new HashMap<> ();
		String spaceshipType;
		for(Spaceship spaceship : fleet) {
			spaceshipType=spaceship.getClass().getSimpleName();
			if(numberPerClass.get(spaceshipType) == null) // first spaceship from this type in the map
				numberPerClass.put(spaceshipType, 1);
			else
				numberPerClass.replace(spaceshipType, numberPerClass.get(spaceshipType)+1);
		}
		return numberPerClass;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalMaintenanceCost = 0;
		for(Spaceship spaceship : fleet) {
			totalMaintenanceCost += spaceship.getAnnualMaintenanceCost();
		}
		return totalMaintenanceCost;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<> ();
		for(Spaceship spaceship : fleet) {
			if(spaceship instanceof Fighter)
				for(Weapon weapon: ((Fighter) spaceship).getWeapon())
					weaponNames.add(weapon.getName()); // No duplicates items in a set
		}
		return weaponNames;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalNumberOfCrewMembers = 0;
		for(Spaceship spaceship : fleet) {
			totalNumberOfCrewMembers += spaceship.getCrewMembers().size();
		}
		return totalNumberOfCrewMembers;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int sumOfOfficerAge=0;
		int totalNumberOfOfficersInFleet=0;
		float averageAgeOfFleetOfficers;
		for(Spaceship spaceship : fleet) {
			for(CrewMember crewMember : spaceship.getCrewMembers()) {
				if(crewMember instanceof Officer) { //Officer in the spaceship
					sumOfOfficerAge += ((Officer) crewMember).getAge(); // Sums up officers age in the fleet
					totalNumberOfOfficersInFleet++;
				}
			}				
		}
		averageAgeOfFleetOfficers = (float) sumOfOfficerAge/totalNumberOfOfficersInFleet;
		return averageAgeOfFleetOfficers;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> highestRankingOfficerPerShip = new HashMap<> ();
		Officer CurrentHighestRankingOfficer = null;
		OfficerRank CurrentHighestRanking = null;
		boolean anyOfficerInSpaceship;
		for(Spaceship spaceship : fleet) {
			anyOfficerInSpaceship = false;
			for(CrewMember crewMember : spaceship.getCrewMembers()) {
			// this loop iterates over the crew members in the spaceship and find the officer with the highest rank 
				if(crewMember instanceof Officer && anyOfficerInSpaceship) { // not the first officer in the spaceship
					if(CurrentHighestRanking.compareTo(((Officer) crewMember).getRank())<0) {
						CurrentHighestRankingOfficer = ((Officer) crewMember);
						CurrentHighestRanking = CurrentHighestRankingOfficer.getRank();
					}
				}
				if(crewMember instanceof Officer && !anyOfficerInSpaceship) { //first officer in this spaceship
					anyOfficerInSpaceship=true;
					CurrentHighestRankingOfficer = ((Officer) crewMember);
					CurrentHighestRanking = CurrentHighestRankingOfficer.getRank();
				}				
			}
			if(anyOfficerInSpaceship)
				highestRankingOfficerPerShip.put(CurrentHighestRankingOfficer, spaceship);
			
		}
		return highestRankingOfficerPerShip;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> popularityOfOfficerRanking = new HashMap<> ();
		List<Map.Entry<OfficerRank, Integer>> officerRanksSortedByPopularity = new ArrayList<> ();
		// Builds a map with officer rank as a keys and their occurrences as a values.
		for(Spaceship spaceship : fleet) { 
			for(CrewMember crewMember : spaceship.getCrewMembers()) {
				if(crewMember instanceof Officer) { // this crewMember is an officer
					if(popularityOfOfficerRanking.get(((Officer) crewMember).getRank()) == null) //first appearance of the current Officer rank
						popularityOfOfficerRanking.put(((Officer) crewMember).getRank(), 1);
					else // Updates the value of this rank by +1
						popularityOfOfficerRanking.put(((Officer) crewMember).getRank(), popularityOfOfficerRanking.get(((Officer) crewMember).getRank())+1);
				}		
			}			
		}
		// Builds a List with map Entries: officer rank as a keys and their occurrences as a values.
		for(Map.Entry<OfficerRank, Integer> officerRankMapEntry : popularityOfOfficerRanking.entrySet())
			officerRanksSortedByPopularity.add(officerRankMapEntry);
		 Collections.sort(officerRanksSortedByPopularity,  new Comparator<Map.Entry<OfficerRank, Integer>>() {
			 //Sort entries ascendingly based on the number of occurrences and then in ascending order by rank name
			 public int compare(Map.Entry<OfficerRank, Integer> s1, Map.Entry<OfficerRank, Integer> s2) {
			        if(s1.getValue().compareTo(s2.getValue())!=0)
			        	return s1.getValue().compareTo(s2.getValue());
			        return s1.getKey().compareTo(s2.getKey());			        	
			    }
		 });
		return officerRanksSortedByPopularity;
	}

}
