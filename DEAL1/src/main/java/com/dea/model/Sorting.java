package com.dea.model;

public class Sorting {
	
	public static final int ARBITRARILY_LONG_NUMBERS = 1;
	public static final int FLOATING_POINT_NUMBERS = 2;
	
	private Methods methods;
	
	private int typeOfNumbers;
	
	public Sorting(int typeOfNumbers) {
		methods = new Methods();
		this.typeOfNumbers = typeOfNumbers;
	}
	
	public Methods getMethods() {
		return methods;
	}
	
	public int getTypeOfNumbers() {
		return typeOfNumbers;
	}
	
	public void merge(int[] numbers) {
		methods.merge(numbers);
	}
	
	public void radix(int[] numbers) {
		methods.radixSort(numbers);
	}
	
	public void heap(int[] numbers) {
		methods.heapSort(numbers);
	}
	
	public double calculateAlgorithmRunTime() {
		return 0;
	}
	
}
