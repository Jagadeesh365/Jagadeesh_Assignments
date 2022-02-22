package com.Stream.Assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Find Out:
 * 
 * 1. What are all the unique cities where the traders work?
 * 
 * 
 * 2. Find all traders from Pune and sort them by name.
 * 
 * 3. Return a string of all traders’ names sorted alphabetically.
 * 
 * 
 * 4. Are any traders based in Indore?
 */

public class Assignment5Q3 {
	public static List<String> printUniqueCities(List<Trader> traders) {
		Set<String> list = new TreeSet<>();
		List<Trader> uniqueList = new ArrayList<>();
		uniqueList = traders.stream().filter(p -> list.add(p.getCity())).distinct()
				.collect(Collectors.toCollection(ArrayList::new));
		List<String> list1 = new ArrayList<>();
		for (Trader trader : uniqueList) {
			list1.add(trader.getCity());
		}
		return list1;
	}

	public static List<String> trader2sFromPuneSortByName(List<Trader> traders) {
		List<String> uniqueList = new ArrayList<>();
		traders.stream().filter(p -> p.getCity().equals("Pune")).sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList()).forEach(p -> uniqueList.add(p.getName()));
		return uniqueList;
	}

	public static String allTrader3Names(List<Trader> traders) {
		String allTrader = "";
		ArrayList<Trader> arrayList = new ArrayList<>();
		arrayList = traders.stream().sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toCollection(ArrayList::new));

		for (Trader trader : arrayList) {
			allTrader += trader.getName();
		}
		return allTrader;
	}

	public static ArrayList<Trader> areAnyTrader4sFromIndore(ArrayList<Trader> traders) {
		ArrayList<Trader> traders1 = traders;
		ArrayList<Trader> traders2 = new ArrayList<>();
		traders2 = traders1.stream().filter(p -> p.getCity().equals("Indore"))
				.collect(Collectors.toCollection(ArrayList::new));
		return traders2;
	}

	public static void main(String[] args) {
		Trader t1 = new Trader("Jgadeesh", "Andhra Pradesh");
		Trader t2 = new Trader("Lokesh", "Pune");
		Trader t3 = new Trader("Pavan Tej", "Andhra Pradesh");
		Trader t4 = new Trader("Amrendra", "Tamil Nadu");
		Trader t5 = new Trader("Harshsri", "Pune");
		Trader t6 = new Trader("Srinivas", "Telangana");
		Trader t7 = new Trader("Karthik", "Tamil Nadu");
		Trader t8 = new Trader("Kalyan", "Tamil Nadu");
		Trader t9 = new Trader("Pradeep", "Indore");

		List<Trader> traders = new ArrayList<>();
		traders.add(t1);
		traders.add(t2);
		traders.add(t3);
		traders.add(t4);
		traders.add(t5);
		traders.add(t6);
		traders.add(t7);
		traders.add(t8);
		traders.add(t9);

		ArrayList<Trader> traders1 = new ArrayList<>();
		traders1.add(t1);
		traders1.add(t2);
		traders1.add(t3);
		traders1.add(t4);
		traders1.add(t5);
		traders1.add(t6);
		traders1.add(t7);
		traders1.add(t8);
		traders1.add(t9);
		System.out.println("All the unique cities where the traders work :\n" + printUniqueCities(traders));
		System.out.println("All traders from Pune and sort them by name  :" + trader2sFromPuneSortByName(traders));

		System.out.println("Traders based in Indore                       :" + areAnyTrader4sFromIndore(traders1));
		System.out.println("Names sorted alphabetically                    :\n" + allTrader3Names(traders));
	}
}
