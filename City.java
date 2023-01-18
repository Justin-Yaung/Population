package Population;

/**
 *	City data - the city name, state name, location designation,
 *				and population est. 2017
 *
 *	@author	Justin Yaung
 *	@since 1/14/23
 */
public class City implements Comparable<City> {
	
	// fields
	private String name;
	private String state;
	private String type;
	private int population;
	
	
	// constructor
	public City(String state, String city, String type, int pop) {
		this.name = city;
		this.state = state;
		this.type = type;
		this.population = pop;
	}

	/**	Compare two cities populations
	 *	@param other		the other City to compare
	 *	@return				the following value:
	 *		If populations are different, then returns (this.population - other.population)
	 *		else if states are different, then returns (this.state - other.state)
	 *		else returns (this.name - other.name)
	 */
	 public int compareTo(City other){
		 if (this.population != other.population){
			 return (this.population - other.population);
		 } else if (this.state != other.state){
			 return this.state.compareTo(other.state);
		 } else {
			 return this.name.compareTo(other.name);
		 }
	 }
	
	/**	Equal city name and state name
	 *	@param other		the other City to compare
	 *	@return				true if city name and state name equal; false otherwise
	 */
	 public boolean equals(City other){
		 if (this.name == other.name && this.state == other.state){
			 return true;
		 }
		 return false;
	 }
	
	/**	Accessor methods */
	 
	 public String getName() {
		 return this.name;
	 }
	
	 public String getState() {
		 return this.state;
	 }
	 
	 public String getType() {
		 return this.type;
	 }
	 
	 public int getPop() {
		 return this.population;
	 }
	
	
	
	/**	toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, type, population);
	}
}
