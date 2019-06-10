package com.nisum.zipcoderanger;

import java.util.ArrayList;
import java.util.List;

import com.nisum.service.ZipCode;


public class MyZipCodeRanger 
{
    public static void main( String[] args )
    {
    	List<Integer> list1 = new ArrayList<>();
		list1.add(94133);
		list1.add(94133);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(46001);
		list2.add(94299);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(94600);
		list3.add(94699);
		
		
		List<List<Integer>> zipCodeList = new ArrayList<>();
		zipCodeList.add(list1);
		zipCodeList.add(list2);
		zipCodeList.add(list3);
		
		ZipCode zipCode = new ZipCode();
		
		System.out.println(zipCode.FindZipCodeRang(zipCodeList));
    }
}
