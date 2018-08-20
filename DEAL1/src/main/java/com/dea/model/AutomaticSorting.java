package com.dea.model;

import java.math.BigInteger;

public class AutomaticSorting extends Sorting{

	public static final int ORDERED_NORMALLY = 1;
	public static final int INVERSELY_ORDERED = 2;
	public static final int ALEATORY_ORDERED = 3;
	
	private boolean repeatedNumbers;
	private BigInteger lowerInterval;
	private BigInteger upperInterval;
	private int typeOfGeneratedNumbers;
	private boolean percentOfDisorder;
	
	public AutomaticSorting(int typeOfNumbers, boolean repeatedNumbers, BigInteger lowerInterval,
			BigInteger upperInterval, int typeOfGeneratedNumbers, boolean percentOfDisorder) {
		super(typeOfNumbers);
		this.repeatedNumbers = repeatedNumbers;
		this.lowerInterval = lowerInterval;
		this.upperInterval = upperInterval;
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

	public int getTypeOfGeneratedNumbers() {
		return typeOfGeneratedNumbers;
	}

	public boolean isPercentOfDisorder() {
		return percentOfDisorder;
	}
	
	public double calculatePercentOfDisorder() {
		return 0;
	}


}
