import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.InputMismatchException;
public class ConnorHomework1 {

	static public class Ex  extends Exception {}

	public static void main(String[] args) throws Exception {
		/*
		* if (args.length != 2) { System.out.println(
		* "Usage: java GuessGame MAX_INT MAX_GUESS"); return; }
		*/

		// This is how you convert a string to an integer:
		int maxInteger = 16; // Integer.parseInt(args[0]);

		// This is the number of guesses the user gets.
		int limit = 4; // Integer.parseInt(args[1]);
		// Extra Credit!
		// For every positive integer n that you pick for "maxInteger" there is
		// a positive integer m that you can pick for limit, such that the user
		// will always guess the number, if they use the right strategy.
		// What is the smallest integer m, given as a function of n, with this
		// property?

		// This creates a new random number generator
		Random rand = new Random();

		// This generates a random integer. Note the "+1"!
		int target = rand.nextInt(maxInteger);

		// This scans input from stdin.
		// (Scanner is a little like cin in C++)
		Scanner input = new Scanner(System.in);
		try {
			// This is how you print to stdout.
			System.out.printf("Guess a number between 1 and %d.\n", maxInteger);

			Set<Integer> guesses = new TreeSet<>();

			// Loop while the number of attempts is less than the number of allowed
			// guesses
			int attempts = 0;
			while (attempts <= limit) {

				int guess;
				System.out.printf("Attempt %d of %d: ", attempts, limit);
				// This is how you get an integer from stdin.
				// (This is like `int guess << cin` in C++.)

				// TODO: Your code goes here!
				// This should take you about 10 lines of code.
				// 1) Check if the user's guess is greater than the target.
				// 2) If it is print "Too High!"
				// 3) Otherwise, check if the user's guess is too low.
				// 4) If it is print "Too Low!"
				// 5) Otherwise, the user must have guessed correct print "You
				// Win!"
				// 6) Make sure you don't let the user guess too many times!
				try {

					guess = input.nextInt();
				} catch (java.util.InputMismatchException ex) {
					System.out.println("Please enter only an integer");
					input.nextLine();
					continue;
				}
				if (guess > maxInteger || guess< 0) { 
					//checks for negative numbers
					System.out.println("Input is out of bound");
					continue;
				}
				if (guesses.contains(guess)) {
					System.out.println("Contains Duplicates");
					continue;
				} else if (guess > target) {
					System.out.println("Too High!");
					guesses.add(guess);
				} else if (guess < target) {
					System.out.println("Too low!");
					guesses.add(guess);
				} else if (guess == target) {
					System.out.println("You Win!");
					return;
				} //else
					//System.out.printf("You guessed %d\n", guess);
			}
			
			System.out.println("You lose!");
			attempts += 1;
		} finally {
			input.close();
		}
		
	}
}