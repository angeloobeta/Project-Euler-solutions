/* 
 * Solution to Project Euler problem 197
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */


public class p197 {
	
	private static long ITERATIONS = 1000000000000L;
	
	
	public static void main(String[] args) {
		// Floyd's cycle-finding algorithm
		double x = -1;
		double y = -1;
		long i = 0;
		for (; i < ITERATIONS; i++) {
			// Here at the top of the loop, x = f^i(-1) and y = f^{2i}(-1)
			
			if (i > 0 && x == y)  // This means index i is part of the cycle, and (2i - i) = i is some multiple of the true cycle length
				break;
			
			// Advance the states at different speeds
			x = f(x);
			y = f(f(y));
		}
		
		// Advance by many multiples of the cycle length, then deal with the remaining iterations
		long remain = (ITERATIONS - i) % i;
		for (; remain > 0; remain--)
			x = f(x);
		double answer = x + f(x);
		answer = Math.floor(answer * Math.pow(10, 9)) / Math.pow(10, 9);  // Truncate to 9 digits after the decimal point
		System.out.printf("%.9f%n", answer);
	}
	
	
	private static double f(double x) {
		return Math.floor(Math.pow(2, 30.403243784 - x * x)) * Math.pow(10, -9);
	}
	
}
