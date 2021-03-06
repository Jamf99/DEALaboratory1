package com.dea.model;

import java.math.BigDecimal;
import java.math.BigInteger;

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
	
	public void mergeBigInteger(BigInteger[] numbers) {
		methods.mergeSortBigInteger(numbers, 0, numbers.length - 1);
	}
	
	public void mergeBigIntegerInversely(BigInteger[] numbers) {
		methods.mergeSortBigIntegerInversely(numbers, 0, numbers.length - 1);
	}
	
	public void mergeBigDecimalInversely(BigDecimal[] numbers) {
		methods.mergeSortBigDecimalInversely(numbers, 0, numbers.length - 1);
	}
	
	public void radixBigInteger(BigInteger[] numbers) {
		methods.radixSortBigInteger(numbers);
	}
	
	public void heapBigInteger(BigInteger[] numbers) {
		methods.heapSortBigInteger(numbers);
	}
	
	public void mergeBigDecimal(BigDecimal[] numbers) {
		methods.mergeSortBigDecimal(numbers, 0, numbers.length - 1);
	}
	
	public void radixBigDecimal(BigDecimal[] numbers) {
		methods.radixSortBigDecimal(numbers);
	}
	
	public void heapBigDecimal(BigDecimal[] numbers) {
		methods.heapSortBigDecimal(numbers);
	}
	/**
	 * This method reads the string and transforms it each value and adds it to the array of big integers
	 * @param string chain of numbers that need to be separate 
	 * @return returns an array of bigIntegers
	 */
	public BigInteger[] transformStringToBigInteger(String string) {
		String[] aux = string.split(",");
		BigInteger[] numbers = new BigInteger[aux.length];
		for(int i = 0; i < aux.length; i++) {
			numbers[i] = new BigInteger(aux[i]);
		}
		return numbers;
	}
	/**
	 * This method reads the string and transforms it each value and adds it to the array of big decimals
	 * @param string chain of numbers that need to be separate 
	 * @return returns an array of BigDecimal
	 */
	public BigDecimal[] transformStringToBigDecimal(String string) {
		String[] aux = string.split(",");
		BigDecimal[] numbers = new BigDecimal[aux.length];
		for(int i = 0; i < aux.length; i++) {
			numbers[i] = new BigDecimal(aux[i]);
		}
		return numbers;
	}
	
}
