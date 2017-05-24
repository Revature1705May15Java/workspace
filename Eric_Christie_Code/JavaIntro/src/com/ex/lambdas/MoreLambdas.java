package com.ex.lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class MoreLambdas {
	
	static String[] strs = {"foo", "bar", "blah", "123", "Hello", "987", "65 ", "abc", "42"};
	
	static Collection<String> collectAllStrings(Collector<String> strCollector, String ... strings) {
		return strCollector.collect(strings);
	}
	
	static Collection<String> collectNonIntegerStrings(Selector<String> numStrSelector, String ... strings) {
		return numStrSelector.select((s) -> {
			try {
				Integer.parseInt(s);
				return false;
			} catch (NumberFormatException e) {
				// this exception is thrown if s cannot be parsed as an integer
				return true;
			}
		}, strings);
	}

	public static void main(String[] args) {
		List<String> all = (List<String>) collectAllStrings((String[] strings) -> {
			List<String> result = new ArrayList<String>();
			for (String s: strings) {
				result.add(s);
			}
			return result;
		}, strs);
		
		List<String> nonInts = (List<String>) collectNonIntegerStrings((Predicate<String> p, String[] strings) -> {
			List<String> result = new ArrayList<String>();
			for (String s: strings) {
				if (p.test(s)) {
					result.add(s);
				}
			}
			return result;
		}, strs);
		
		System.out.println("All strings: " + all);
		System.out.println("Non-integer strings: " + nonInts);
	}

}

interface Collector<T> {
	/*
	 * returns a collection containing all the input parameters
	 */
	Collection<T> collect(/*Class<? extends Collection<T>> collectionType, */T ... ts);
}

interface Selector<T> {
	/*
	 * returns a collection containing only the input parameters that pass some test case
	 */
	Collection<T> select(/*Class<? extends Collection<T>> collectionType, */Predicate<T> pred, T ... ts);
}
