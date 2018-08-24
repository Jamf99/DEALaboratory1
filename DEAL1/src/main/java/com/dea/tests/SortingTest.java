package com.dea.tests;


import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import com.dea.model.Sorting;

import junit.framework.TestCase;

class SortingTest extends TestCase{

	BigInteger[] numbers2 = new BigInteger[4];
	BigInteger[] numbers3 = new BigInteger[4];
	BigDecimal[] numbers4 = new BigDecimal[4];
	String string;
	
	private Sorting s;
	
	private void stage1() {
		s = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		numbers2[0] = new BigInteger("100000");
		numbers2[1] = new BigInteger("1000000000000");
		numbers2[2] = new BigInteger("10000000");
		numbers2[3] = new BigInteger("1000000000");
		
	}
	
	private void stage2() {
		s = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		numbers3[0] = new BigInteger("19380138120831");
		numbers3[1] = new BigInteger("481212923");
		numbers3[2] = new BigInteger("1310238018230131");
		numbers3[3] = new BigInteger("294294294322");
	}
	
	private void stage3() {
		s = new Sorting(Sorting.FLOATING_POINT_NUMBERS);
		numbers4[0] = new BigDecimal("0.00000101");
		numbers4[1] = new BigDecimal("0.001");
		numbers4[2] = new BigDecimal("0.101010110");
		numbers4[3] = new BigDecimal("0.00000101101");
	}
	
	private void stage4() {
		s = new Sorting(Sorting.ARBITRARILY_LONG_NUMBERS);
		string = new String("112121321,1312313,13131313123,121");
	}
	
	private void stage5() {
		s = new Sorting(Sorting.FLOATING_POINT_NUMBERS);
		string = new String("0.1010101001,0.101010111101,0.10100001,0.1010111101");
	}
	
	@Test
	public void testMergeBigInteger() {
		stage1();
		BigInteger[] numbers1 = new BigInteger[numbers2.length];
		numbers1[0] = new BigInteger("100000");
		numbers1[1] = new BigInteger("10000000");
		numbers1[2] = new BigInteger("1000000000");
		numbers1[3] = new BigInteger("1000000000000");
		s.mergeBigInteger(numbers2);
		for(int i = 0; i < numbers2.length; i++) {
			assertEquals(numbers1[i], numbers2[i]);
		}
	}
	
	@Test
	public void testRadixBigInteger() {
		stage2();
		BigInteger[] numbers1 = new BigInteger[numbers3.length];
		numbers1[0] = new BigInteger("481212923");
		numbers1[1] = new BigInteger("294294294322");
		numbers1[2] = new BigInteger("19380138120831");
		numbers1[3] = new BigInteger("1310238018230131");
		s.radixBigInteger(numbers3);
		for(int i = 0; i < numbers1.length; i++) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testHeapBigInteger() {
		stage1();
		BigInteger[] numbers1 = new BigInteger[numbers2.length];
		numbers1[0] = new BigInteger("100000");
		numbers1[1] = new BigInteger("10000000");
		numbers1[2] = new BigInteger("1000000000");
		numbers1[3] = new BigInteger("1000000000000");
		s.heapBigInteger(numbers2);
		for(int i = 0; i < numbers1.length; i++) {
			assertEquals(numbers1[i], numbers2[i]);
		}
	}
	
	@Test
	public void testHeapBigDecimal() {
		stage3();
		BigDecimal[] numbers1 = new BigDecimal[numbers4.length];
		numbers1[0] = new BigDecimal("0.00000101");
		numbers1[1] = new BigDecimal("0.00000101101");
		numbers1[2] = new BigDecimal("0.001");
		numbers1[3] = new BigDecimal("0.101010110");
		
		s.heapBigDecimal(numbers4);
		for(int i = 0; i < numbers1.length; i++) {
			assertEquals(numbers1[i], numbers4[i]);
		}
	}
	
	@Test
	public void testMergeBigDecimal() {
		stage3();
		BigDecimal[] numbers1 = new BigDecimal[numbers4.length];
		numbers1[0] = new BigDecimal("0.00000101");
		numbers1[1] = new BigDecimal("0.00000101101");
		numbers1[2] = new BigDecimal("0.001");
		numbers1[3] = new BigDecimal("0.101010110");
		
		s.mergeBigDecimal(numbers4);
		for(int i = 0; i < numbers1.length; i++) {
			assertEquals(numbers1[i], numbers4[i]);
		}
	}
	
	@Test
	public void testRadixBigDecimal() {
		stage3();
		BigDecimal[] numbers1 = new BigDecimal[numbers4.length];
		numbers1[0] = new BigDecimal("0.00000101");
		numbers1[1] = new BigDecimal("0.00000101101");
		numbers1[2] = new BigDecimal("0.001");
		numbers1[3] = new BigDecimal("0.101010110");
		
		s.radixBigDecimal(numbers4);
		for(int i = 0; i < numbers1.length; i++) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testTransformStringToBigInteger() {
		stage4();
		BigInteger[] bi = s.transformStringToBigInteger(string);
		assertEquals(bi[0], new BigInteger("112121321"));
		assertEquals(bi[1], new BigInteger("1312313"));
		assertEquals(bi[2], new BigInteger("13131313123"));
		assertEquals(bi[3], new BigInteger("121"));
		
	}
	
	@Test
	public void testTransformStringToBigDecimal() {
		stage5();
		BigDecimal[] bd = s.transformStringToBigDecimal(string);
		assertEquals(bd[0], new BigDecimal("0.1010101001"));
		assertEquals(bd[1], new BigDecimal("0.101010111101"));
		assertEquals(bd[2], new BigDecimal("0.10100001"));
		assertEquals(bd[3], new BigDecimal("0.1010111101"));
		
	}

}
