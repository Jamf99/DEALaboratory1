package com.dea.model;

import java.util.ArrayList;

public class Methods {
	
	public Methods() {
		
	}
	
	public ArrayList mergeSort(ArrayList numbers) {
		return merge(numbers, 0, numbers.size());
	}
	
	public ArrayList merge(ArrayList numbers, int izq, int der) {
		if(izq < der) {
			int m = (izq + der) / 2;
			merge(numbers, izq, m);
			merge(numbers, m+1, der);
			merges(numbers, izq, m, der);
		}
		return numbers;
	}
	
	public void merges(ArrayList numbers, int izq, int m, int der) {
		int i, j, k;
	}
	
	public ArrayList radixSort(ArrayList numbers) {
		return numbers;
	}
	
	public ArrayList heapSort(ArrayList numbers) {
		return numbers;
	}
	
}