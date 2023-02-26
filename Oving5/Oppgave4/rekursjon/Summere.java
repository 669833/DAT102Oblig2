package rekursjon;

public class Summere {

	public static int sum(int n) {

		if (n == 1) {
			return 1;
		} else
			return n + sum(n-1);
	}

	public static int an(int n) {

		int number = 0;

		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 5;
		}
		number = (5 * an(n-1)) - (6 * an(n-2)) + 2;
		return number;
	}

	public static int fibonacciRecursive(int n) {

		if (n < 2) {
			return n;
		}

		int number = fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
		return number;
	}

	public static int fibonacci(int n) {

		if (n < 2) {
			return n;
		}

		int x = 0;
		int y = 1;
		int number = 0;

		for (int i = 2; i <= n; i++) {
			number = x + y;
			x = y;
			y = number;
		}
		return number;
	}

	public static void main(String[] args) {

//		//				Oppgave 4a
//		System.out.print(sum(100)); //summen av de 100 første naturlige tallene
//
//		//				Opppgave 4b
//		for (int i = 0; i < 10; i++) {
//			System.out.print(an(i) + " "); 
//		}
//
//		//				Oppgave 4c
//		System.out.print(fibonacciRecursive(9));
//
//		//				Oppgave 4d
//		System.out.print(fibonacci(9));

	}
}


