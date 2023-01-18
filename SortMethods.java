package Population;

import java.util.List;

public class SortMethods {

	Population pop = new Population();
	
	public void selectSort(List<City> city) { //a. sort cities in descending population order
		int n = city.size();
		for (int i = 0; i < n-1; i++)
		{
			int min = i;
			for (int j = i + 1; j < n; j++){
				if (city.get(j).compareTo(city.get(min)) > 0){
					min = j;
				}
			}

			City temp = city.get(min);
			city.set(min,city.get(i));
			city.set(i,temp);
		}
	}

	public void selectionSort(List<City> city) { //a. sort cities in ascending population order
		int n = city.size();
		for (int i = 0; i < n-1; i++)
		{
			int min = i;
			for (int j = i + 1; j < n; j++){
				if (city.get(j).compareTo(city.get(min)) < 0){
					min = j;
				}
			}

			City temp = city.get(min);
			city.set(min,city.get(i));
			city.set(i,temp);
		}
	}

	//merge sort for descending population order
	public void merge(List<City> city, int p, int q, int r) {
		
		int n1 = q - p + 1;
		int n2 = r - q;

		City[] L = new City[n1];
		City[] M = new City[n2];

		for (int i = 0; i < n1; i++){
			L[i] = city.get(p+i);
		}
		for (int j = 0; j < n2; j++) {
			M[j] = city.get(q + 1 + j);
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) {
			if (L[i].compareTo(M[i]) < 0) {
				city.set(k,L[i]);
				i++;
			} else {
				city.set(k,M[j]);
				j++;
			}
			k++;
		}

		while (i < n1) {
			city.set(k,L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			city.set(k,M[j]);
			j++;
			k++;
		}
	}

	public void mergeSort(List<City> city, int l, int r) {
		if (l < r) {

			// m is the point where the array is divided into two subarrays
			int m = (l + r) / 2;

			mergeSort(city, l, m);
			mergeSort(city, m + 1, r);

			// Merge the sorted subarrays
			merge(city, l, m, r);
		}
	}

	public void insertionSort(List<City> city) { //cities in ascending name order
		
		int size = city.size();

		for (int step = 1; step < size; step++) {
			City key = city.get(step);
			int j = step - 1;

			// Compare key with each element on the left of it until an element smaller than
			// it is found.
			// For descending order, change key<array[j] to key>array[j].
			while (j >= 0 && key.getName().compareTo(city.get(j).getName()) < 0) {
				city.set(j+1, city.get(j));
				--j;
			}

			// Place key at after the element just smaller than it.
			city.set(j+1, key);
		}
	}

	public void merge2(List<City> city, int p, int q, int r) {

		int n1 = q - p + 1;
		int n2 = r - q;

		City[] L = new City[n1];
		City[] M = new City[n2];

		for (int i = 0; i < n1; i++){
			L[i] = city.get(p+i);
		}
		for (int j = 0; j < n2; j++) {
			M[j] = city.get(q + 1 + j);
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) {
			if (L[i].getName().compareTo(M[i].getName()) < 0) {
				city.set(k,L[i]);
				i++;
			} else {
				city.set(k,M[j]);
				j++;
			}
			k++;
		}

		while (i < n1) {
			city.set(k,L[i]);
			i++;
			k++;
		}

		while (j < n2) {
			city.set(k,M[j]);
			j++;
			k++;
		}
	}

	public void mergeSort2(List<City> city, int l, int r) {	
		if (l < r) {

			// m is the point where the array is divided into two subarrays
			int m = (l + r) / 2;

			mergeSort(city, l, m);
			mergeSort(city, m + 1, r);

			// Merge the sorted subarrays
			merge(city, l, m, r);
		}
	}
}
