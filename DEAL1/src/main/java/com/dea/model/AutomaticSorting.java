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
	
	public BigInteger[] generatorBigInteger(double min, double max, int quantity) {
		BigInteger[] numbers = new BigInteger[quantity];
		int low = (int)(max-min)+1;
		if(isRepeatedNumbers()) {
			for(int i = 0; i < quantity; i++) {
				numbers[i] = BigDecimal.valueOf(Math.random() * low + min).toBigInteger();
			}
		}else {
			if(low >= quantity) {
				for(int i = 0; i < quantity; i++) {
					numbers[i] = BigDecimal.valueOf(Math.random() * low + min).toBigInteger();
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
