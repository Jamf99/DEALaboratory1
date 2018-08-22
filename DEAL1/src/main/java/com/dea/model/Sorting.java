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
	
	public void merge(double[] numbers, int low, int high) {
		methods.mergeSort(numbers, low, high);
	}
	
	public void radix(double[] numbers) {
		methods.radixSort(numbers);
	}
	
	public void heap(double[] numbers) {
		methods.heapSort(numbers);
	}
	
	public double[] transformStringToDouble(String string) {
		String[] aux = string.split(",");
		double[] numbers = new double[aux.length];
		for(int i = 0; i < aux.length; i++) {
			numbers[i] = Double.parseDouble(aux[i]);
		}
		return numbers;
	}
	
}
