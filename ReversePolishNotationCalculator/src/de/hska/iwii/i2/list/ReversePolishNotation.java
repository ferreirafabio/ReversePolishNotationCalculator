package de.hska.iwii.i2.list;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

/**
 * This method provides a calculator for the mathematical notation RPN in which
 * every operator follows all of its operands, known as postfix notation.
 * 
 * @author Fábio Ferreira
 *
 */
public class ReversePolishNotation {

	/**
	 * Calculates the result of a RPN/postfix notation using lambda expressions
	 * and the functional interface IntBinaryOperator for a easy-to-read
	 * implementation. This calculator does not test the postfix notation for
	 * correctness.
	 * 
	 * @param exp
	 *            A well-formed mathematical expression in RPN notation, e.g.:
	 *            "4 2 3 + +"
	 * @return the mathematical correct result.
	 */
	public static int calculate(String exp) {
		String token;
		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(exp);

		while (st.hasMoreTokens()) {
			token = st.nextToken();
			// int a,b;
			if (token.equals("+")) {
				stack.push(operateBinary(stack.pop(), stack.pop(), (a, b) -> a
						+ b));
				// stack.push(add(stack.pop(), stack.pop()));
			} else if (token.equals("-")) {
				// a = stack.pop();
				// b = stack.pop();
				// stack.push(sub(b, a));
				stack.push(operateBinary(stack.pop(), stack.pop(), (a, b) -> a
						- b));
			} else if (token.equals("*")) {
				// stack.push(mul(stack.pop(), stack.pop()));
				stack.push(operateBinary(stack.pop(), stack.pop(), (a, b) -> a
						* b));
			} else if (token.equals("/")) {
				// stack.push(div(stack.pop(), stack.pop()));
				stack.push(operateBinary(stack.pop(), stack.pop(), (a, b) -> a
						/ b));
			} else {
				stack.push(Integer.parseInt(token));
			}

		}
		return stack.pop();
	}

	/**
	 * operateBinary applies a mathematical function for two operands. 
	 * Switching the operands is necessary because of the subtraction case.
	 * 
	 * @param a
	 *            first operand.
	 * @param b
	 *            second operand.
	 * @param operator
	 *            one of the following operators: +-*&#47
	 * @return
	 */
	private static int operateBinary(int a, int b, IntBinaryOperator operator) {
		return operator.applyAsInt(b, a); // inverted because of subtraction
											// case (a - b != b - a)
	}
}
