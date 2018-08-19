package com.dea.model;

public class Sorting {
	
	Methods methods;
	
	public Sorting() {
		methods = new Methods();
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
	
}
