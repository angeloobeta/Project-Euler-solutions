/* 
 * Solution to Project Euler problem 38
 * By Nayuki Minase
 * 
 * http://nayuki.eigenstate.org/page/project-euler-solutions
 * https://github.com/nayuki/Project-Euler-solutions
 */

import java.util.Arrays;


public class p038 {
	
	public static void main(String[] args) {
		int max = -1;
		for (int n = 2; n <= 9; n++) {
			for (int i = 1; i < Library.pow(10, 9 / n); i++) {
				String concat = "";
				for (int j = 1; j <= n; j++)
					concat += i * j;
				if (isPandigital(concat))
					max = Math.max(Integer.parseInt(concat), max);
			}
		}
		System.out.println(max);
	}
	
	
	private static boolean isPandigital(String s) {
		if (s.length() != 9)
			return false;
		char[] temp = s.toCharArray();
		Arrays.sort(temp);
		return new String(temp).equals("123456789");
	}
	
}
