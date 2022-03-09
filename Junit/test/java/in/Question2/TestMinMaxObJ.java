package in.Question2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestMinMaxObJ {
	static MinMaxObj oExpected;
	static MinMaxObj oActual;
	static MinMaxObj ex;

	@BeforeAll
	static void setup() {
		oExpected = new MinMaxObj();
		oActual = new MinMaxObj();
		ex = new MinMaxObj();
	}

	@Test
	@DisplayName("Test case 1")
	void minMax1() {
		oActual.setMin(2);
		oActual.setMax(96);
		ex = oExpected.FindMinMax(new int[] { 96, 62, 15, 2, 86, 2, 44, 44, 73 });
		assertEquals(oActual, ex);
	}

	@Test
	@DisplayName("Test case 2")
	void minMax2() {
		oActual.setMin(2);
		oActual.setMax(2);
		ex = oExpected.FindMinMax(new int[] { 2, 2 });
		assertEquals(oActual, ex);
	}
	
	@Test
	@DisplayName("Test case 2")
	void minMax3() {
		assertThrows(ArrayIndexOutOfBoundsException.class,()->oExpected.FindMinMax(new int[] {}));
	}

}