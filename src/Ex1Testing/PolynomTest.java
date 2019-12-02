package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Polynom;

class PolynomTest {

	@Test
	void testCopy() {
		Polynom p1 = new Polynom("3x^2+17-3x^4-2x");
		System.out.println(p1.toString());
		Polynom p2 = (Polynom) p1.copy();
		System.out.println(p2.toString());
		assertEquals(p1,p2,"error");
	}

}
