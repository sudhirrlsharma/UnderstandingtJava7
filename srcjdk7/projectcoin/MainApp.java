package projectcoin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {
	public static void main(String[] args) {
		List<String> stringLists = new ArrayList<>();
		stringLists.add("sudhri");
		testNumber();
		testSwitchWithString();
		testMultiCatch();
		testSafeVargarExample();
	}

	private static void testNumber() {
		int test = 4_444;
		long creditCart = 4444_3333_2222_1111L;
		System.out.println(creditCart);
		System.out.println(test);
	}

	/**
	 * Language Changes – Strings in switch
	 */
	private static void testSwitchWithString() {
		String day = "Monday";
		switch (day) {
		case "Monday":
			System.out.println("Khuni Monday");
			break;
		case "Friday":
			System.out.println("Party time");
			break;
		default:
			System.err.println("As usual");
			break;
		}

	}

	private static void testMultiCatch() {
		TestException exception = new TestException();
		exception.testMultiCatchException();
	}

	/**
	 * Language Changes – Improved Type Inference
	 */
	public static void testTypeImproved() {
		HashMap<Date, String> aMap = new HashMap<>();
		aMap.put(new Date(), "Hello");
		List<Map<Date, String>> listOfMaps = new ArrayList<>();
		listOfMaps.add(aMap);
		System.out.println(listOfMaps);
	}

//	@SafeVarargs
	static <T> void testSafeVarargs(T... a) {
		for (T t : a) {
			System.out.println(t);
		}
	}
	
	static void testSafeVargarExample(){
		testSafeVarargs("Hello", "World");
		testSafeVarargs(new ArrayList<String>(), new ArrayList<String>());
	}

}
