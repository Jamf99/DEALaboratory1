package com.dea.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AutomaticSorting extends Sorting{

	public static final int ORDERED_NORMALLY = 0;
	public static final int INVERSELY_ORDERED = 1;
	public static final int ALEATORY_ORDERED = 2;
	
	private boolean repeatedNumbers;
	private BigInteger lowerInterval;
	private BigInteger upperInterval;
	private int lengthOfNumbers;
	private int typeOfGeneratedNumbers;
	private boolean percentOfDisorder;
	
	public AutomaticSorting(int typeOfNumbers, boolean repeatedNumbers, BigInteger lowerInterval,
			BigInteger upperInterval, int lengthOfNumbers, int typeOfGeneratedNumbers, boolean percentOfDisorder) {
		super(typeOfNumbers);
		this.repeatedNumbers = repeatedNumbers;
		this.lowerInterval = lowerInterval;
		this.upperInterval = upperInterval;
		this.lengthOfNumbers = lengthOfNumbers;
		this.typeOfGeneratedNumbers = typeOfGeneratedNumbers;
		this.percentOfDisorder = percentOfDisorder;
	}

	public boolean isRepeatedNumbers() {
		return repeatedNumbers;
	}

	public BigInteger getLowerInterval() {
		return lowerInterval;
	}

	public BigInteger getUpperInterval() {
		return upperInterval;
	}
	
	public int getLengthOfNumbers() {
		return lengthOfNumbers;
	}

	public int getTypeOfGeneratedNumbers() {
		return typeOfGeneratedNumbers;
	}

	public boolean isPercentOfDisorder() {
		return percentOfDisorder;
	}
	
	public double calculatePercentOfDisorder() {
		return 0;
	}
	/**
	 * This method allows to generate arbitrary BigIntegers, by a interval of minimum value and maximum value, also the quantity of the number
	 * 
	 * @param min this is minimum value that the number can be
	 * @param max this is the maximum value the number can be
	 * @param quantity this is the amount of the numbers that it will create
	 * @return returns an array of big integers with all of the boxes fill
	 */
	public BigInteger[] generatorBigInteger(BigInteger min, BigInteger max, int quantity) {
		BigInteger[] numbers = new BigInteger[quantity];
		double low = (int)(max.doubleValue()-min.doubleValue())+1;
		if(isRepeatedNumbers()) {
			for(int i = 0; i < quantity; i++) {
				numbers[i] = BigDecimal.valueOf(Math.random() * low + min.doubleValue()).toBigInteger();
			}
		}else {
			if(low >= quantity) {
				for(int i = 0; i < quantity; i++) {
					numbers[i] = BigDecimal.valueOf(Math.random() * low + min.doubleValue()).toBigInteger();
					for(int j = 0; j < i; j++) {
						if(numbers[i] == numbers[j]) {
							i--;
						}
					}
				}
			}
		}
		return numbers;
	}
	/**
	 * This method allows to generate big decimal numbers for the floating numbers that the program needs
	 * @param min this is the minimum value that the number can be
	 * @param max this is the maximum value the number can be
	 * @param quantity this is the amount of numbers that the program will create 
	 * @return returns an array of BigDecimal with all of the boxes fill
	 */
	public BigDecimal[] generatorBigDecimal(BigDecimal min, BigDecimal max, int quantity) {
		BigDecimal[] numbers = new BigDecimal[quantity];
		double low = (int)(max.doubleValue()-min.doubleValue())+1;
		if(isRepeatedNumbers()) {
			for(int i = 0; i < quantity; i++) {
				numbers[i] = BigDecimal.valueOf(Math.random() * low + min.doubleValue());
			}
		}else {
			if(low >= quantity) {
				for(int i = 0; i < quantity; i++) {
					numbers[i] = BigDecimal.valueOf(Math.random() * low + min.doubleValue());
					for(int j = 0; j < i; j++) {
						if(numbers[i] == numbers[j]) {
							i--;
						}
					}
				}
			}
		}
		return numbers;
	}


}
