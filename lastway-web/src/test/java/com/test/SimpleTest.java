package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;

public class SimpleTest {
	public static void main(String[] args) {
		List<String> testData = new ArrayList<>();
		List<String> excludeData = new ArrayList<>();
		
		testData.add("0001");
		testData.add("0002");
		testData.add("0003");
		testData.add("0003");
		testData.add("0005");
		testData.add("0078");
		testData.add("0012");
		testData.add("0991");
		testData.add("1001");
		
		excludeData.add("0001");
		excludeData.add("0078");
		
		simpleForLoopOperator(testData, excludeData);
		
		lambdaOperator(testData, excludeData);
	}
	
	public static void simpleForLoopOperator(List<String> data, List<String> exludeData) {
		System.out.println("============= Classic for Loop  ==============");
		
		//data.forEach(u -> System.out.println(u));
		List<String> result = new ArrayList<>();
		
		for ( String d : data ) {
			if ( d != null && !d.equals("") ) {
				Iterator<String> exIterator = exludeData.iterator();
				while ( exIterator.hasNext() ) {
					String temp = exIterator.next();
					if ( d.equalsIgnoreCase(temp) )
						result.add(temp);
				}
			}
		}
		
		System.out.println(result);
		System.out.println("============= End for Loop Test ==============");
	}
	
	public static void lambdaOperator(List<String> data, List<String> exludeData) {
		System.out.println("============= Lambda Operator  ==============");
		
		
		//result.forEach(u->System.out.println(u));
		System.out.println("============= End Lambda Operator Test ==============");
	}
}
