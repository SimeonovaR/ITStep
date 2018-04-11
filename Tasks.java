package tasks1104;

public class Tasks {
	public static long fibonacci(long number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		return fibonacci(number-1) + fibonacci(number-2);
	}
	
	public static boolean fibonacciNum(long numberToFind) {
		int i = 0;
		while(fibonacci(i) <= numberToFind) {
			if(fibonacci(i) == numberToFind) {
				return true;
			}
			i++;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(fibonacci(10)); 
		System.out.println(fibonacciNum(6766));
	}

}
