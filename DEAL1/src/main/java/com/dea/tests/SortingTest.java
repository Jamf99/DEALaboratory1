package com.dea.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.dea.model.Sorting;

import junit.framework.TestCase;

class SortingTest extends TestCase{

	double[] numbers1 = {8,3,4,11,15,0,9,12,10,7.5,7.01,8,10,6,14};
	int[] numbers2 = {15,14,13,12,11,10,1,2,3,4,5,8,7,6,9};
	
	private Sorting s;
	
	private void stage1() {
		s = new Sorting();
	}
	
	@Test
	public void testMerge() {
		stage1();
		double[] n = {0,3,4,6,7.01,7.5,8,8,9,10,10,11,12,14,15};
		s.merge((numbers2));
		for(int i = 0; i < n.length; i++) {
			assertEquals(n[i], numbers2[i]);
		}
	}
	
	@Test
	public void testRadix() {
		stage1();
		int[] n = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		s.radix(numbers2);
		assertArrayEquals(n, numbers2);
	}
	
	@Test
	public void testHeap() {
		stage1();
		double[] n = {0,3,4,6,7.01,7.5,8,8,9,10,10,11,12,14,15};
		s.heap(numbers2);
		for(int i = 0; i < n.length; i++) {
			assertEquals(n[i], numbers1[i]);
		}
	}

}
