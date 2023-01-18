package Population;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Justin Yaung
 *	@since	1/14/23
 */
public class Population {

	//fields
	Prompt prompt = new Prompt();


	// List of cities
	private List<City> cities = new ArrayList<City>();

	// US data file
	private final String DATA_FILE = "usPopData2017.txt";

	public void readData(){
		Scanner in = FileUtils.openToRead(DATA_FILE).useDelimiter("[\t\n]");
		int i = 0;
		String state = "";
		String city = "";
		String type = "";
		int pop = 0;

		while (in.hasNext()){
			if (i % 4 == 0){
				state = in.next();
			} else if (i % 4 == 1){
				city = in.next();
			} else if (i % 4 == 2){
				type = in.next();
			} else if (i % 4 == 3){
				pop = Integer.parseInt(in.next().trim());
				cities.add(new City(state,city,type,pop));
			}
			i++;
		}
	}

	public static void main(String[] args) {
		Population population = new Population();

		population.readData();
		population.run();
	}

	public void run() {
		SortMethods sm = new SortMethods();

		printIntroduction();
		printMenu();

		int choice = 0;
		while (choice != 9) {
			choice = Prompt.getInt("Enter selection");
			if (choice == 1) {
				long start = System.currentTimeMillis();
				sm.selectionSort(cities);
				System.out.println("50 Least Populous Cities");
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");
				for (int i = 1; i <= 50; i++) {
					City city = cities.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			} else if (choice == 2) {
				long start = System.currentTimeMillis();
				sm.mergeSort(cities, 0, cities.size()-1);
				System.out.println("Fifty most populous cities");
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");
				for (int i = 1; i <= 50; i++) {
					City city = cities.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			} else if (choice == 3) {
				long start = System.currentTimeMillis();
				sm.insertionSort(cities);
				System.out.println("Fifty cities sorted by name");
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");
				for (int i = 1; i <= 50; i++) {
					City city = cities.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			} else if (choice == 4) {
				long start = System.currentTimeMillis();
				sm.mergeSort2(cities,0,cities.size()-1);
				System.out.println("Last fifty cities sorted by name descending");
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");
				for (int i = 1; i <= 50; i++) {
					City city = cities.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			} else if (choice == 5) {
				long start = System.currentTimeMillis();

				String state = Prompt.getString("Enter state name (ie. Alabama)");
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");

				List<City> fives = new ArrayList<City>();
				for (int i = 0; i < cities.size(); i++) {
					if (cities.get(i).getState().equals(state)) {
						fives.add(cities.get(i));
					}
				}
				sm.selectSort(fives);
				System.out.println(fives.size());
				for (int i = 1; i <= 50; i++) {
					City city = fives.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			} else if (choice == 6) {
				long start = System.currentTimeMillis();

				String cityName = Prompt.getString("Enter city name");
				
				System.out.printf("%-15s %-25s %-15s %-20s%n","State","City","Type","Population");
				
				List<City> sixes = new ArrayList<City>();
				for (int i = 0; i < cities.size(); i++) {
					if (cities.get(i).getName().equals(cityName)) {
						sixes.add(cities.get(i));
					}
				}

				sm.selectSort(sixes);
				for (int i = 1; i <= sixes.size(); i++) {
					City city = sixes.get(i-1);
					System.out.printf("%5s %-15s%-25s%-15s%-20s%n", i + ":", city.getState(), city.getName(), city.getType(), city.getPop());
				}
				long end = System.currentTimeMillis();
				System.out.println("\nElapsed Time " + (end-start) + " milliseconds\n");
			}
		}
	}


	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}

	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}

}

