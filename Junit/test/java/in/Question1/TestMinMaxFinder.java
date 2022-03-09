package in.Question1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMinMaxFinder {
	static MinMaxFinder minMaxFinder;

	@BeforeAll
	static void setup() {
		minMaxFinder = new MinMaxFinder();
	}

	@Test
	@DisplayName("Test case 1")
	void testMinMax1() {
		assertArrayEquals(new int[] { 3, 56 }, minMaxFinder.findMinMax(new int[] { 56, 34, 7, 3, 54, 3, 34, 34, 53 })); // This
																														// will
																														// work
	}

	@Test
	@DisplayName("Test case 2")
	void testMinMax2() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> minMaxFinder.findMinMax(new int[] {}));
	}
	
	@Test
	@DisplayName("Test case 3")
	void testMinMax3() {
		assertArrayEquals(new int[] { 3, 3 }, minMaxFinder.findMinMax(new int[] { 3,3 }));
	}

}
