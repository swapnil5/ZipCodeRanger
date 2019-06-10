package com.nisum.zipcoderanger;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.nisum.service.ZipCode;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	ZipCode zipCode;
	
	@Before
    public void setUp() throws Exception {
		 zipCode = new ZipCode();
    }
	
	@Test
	public void emptyListTest() {
		
		List<List<Integer>> list = new ArrayList<>();
		//ZipCode zipCode = new ZipCode();
		assertEquals(list, zipCode.FindZipCodeRang(list));		
	}

	@Test
	public void findMinimunRangTest() {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(94133);
		list1.add(94133);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(94200);
		list2.add(94299);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(94600);
		list3.add(94699);
		
		
		List<List<Integer>> originalList = new ArrayList<>();
		originalList.add(list1);
		originalList.add(list2);
		originalList.add(list3);
		
		//ZipCode zipCode = new ZipCode();
		assertEquals(originalList, zipCode.FindZipCodeRang(originalList));		
	}
	
	@Test
	public void ifAnyListIsEmpty() {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(94133);
		list1.add(94133);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(94200);
		list2.add(94299);
		
		List<Integer> list3 = new ArrayList<>();
		
		
		List<List<Integer>> originalList = new ArrayList<>();
		originalList.add(list1);
		originalList.add(list2);
		originalList.add(list3);
		
		List<List<Integer>> expectedOutput = new ArrayList<>();
		expectedOutput.add(list1);
		expectedOutput.add(list2);
		
		//ZipCode zipCode = new ZipCode();
		
		assertEquals(expectedOutput, zipCode.FindZipCodeRang(originalList));		
	}
	
	@Test
	public void listHaveMoreThanTwoValue() {
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(94133);
		list1.add(94133);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(94200);
		list2.add(94299);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(94400);
		list3.add(94450);
		list3.add(94480);
		list3.add(94499);
		
		List<List<Integer>> input = new ArrayList<>();
		input.add(list1);
		input.add(list2);
		input.add(list3);
		
		List<Integer> expect = new ArrayList<>();
		expect.add(94400);
		expect.add(94499);
		
		List<List<Integer>> expectedOutput = new ArrayList<>();
		expectedOutput.add(list1);
		expectedOutput.add(list2);
		expectedOutput.add(expect);
		
		//ZipCode zipCode = new ZipCode();
		
		assertEquals(expectedOutput, zipCode.FindZipCodeRang(input));		
	}
    
}
