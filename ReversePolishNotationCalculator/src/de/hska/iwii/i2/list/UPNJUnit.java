package de.hska.iwii.i2.list;

import static org.junit.Assert.*;

import org.junit.Test;

public class UPNJUnit {

	@Test
	public void add() {
		String exp = new String("2 2 +");
		assertEquals(ReversePolishNotation.calculate(exp), 4);
	}

	@Test
	public void mul() {
		String exp = new String("2 3 *");
		assertEquals(ReversePolishNotation.calculate(exp), 6);
	}
	
	@Test
	public void div() {
		String exp = new String("6 2 /");
		assertEquals(ReversePolishNotation.calculate(exp), 3);
	}
	
	@Test
	public void subPositive() {
		String exp = new String("6 2 -");
		assertEquals(ReversePolishNotation.calculate(exp), 4);
	}
	
	@Test
	public void subNegative() {
		String exp = new String("2 6 -");
		assertEquals(ReversePolishNotation.calculate(exp), -4);
	}
	
	@Test
	public void threeStackElements() {
		String exp = new String("2 6 5 - -");
		assertEquals(ReversePolishNotation.calculate(exp), 1);
	}
	
	@Test
	public void fourStackElements() {
		String exp = new String("2 6 5 7 - - +");
		assertEquals(ReversePolishNotation.calculate(exp), 10);
	}
	
}
