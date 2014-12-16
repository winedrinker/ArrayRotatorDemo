package csaba.rotator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Small class to show ArrayRotator class usage.
 *
 * @author csaba
 *
 */
public class ArrayRotatorDemo {

	public static void main(final String[] args) {

		new ArrayRotator().run();
	}

	/**
	 * Class to manage user inputs from the console which are the positions and an array of integers.
	 * Rotate the array with the given positions and print original and rotated array to the console.
	 *
	 * @author csaba
	 *
	 */
	final protected static class ArrayRotator {

		private static final int NO_MORE_INPUT = -1344099;

		private static final String POS_MESSAGE = "Please enter positions for the array rotation: "; //$NON-NLS-1$
		private static final String ANY_KEY_MESSAGE = "(Type any key + enter to quit)"; //$NON-NLS-1$
		private static final String ARRAY_MESSAGE = "Please enter the integers for the array: "; //$NON-NLS-1$

		private static final String ORIG_ARRAY_MESSAGE = "The original array was: "; //$NON-NLS-1$
		private static final String ROTATED_ARRAY_MESSAGE = "The rotated array is: "; //$NON-NLS-1$


		private final Scanner scanner;
		private int positions;
		private final List<Integer> inputArray = new ArrayList<>();
		private final List<Integer> rotatedArray = new ArrayList<>();

		protected ArrayRotator() {
			super();
			this.scanner = new Scanner(System.in);
		}

		protected void run() {

			// Read positions from the console
			System.out.println(POS_MESSAGE);
			System.out.println(ANY_KEY_MESSAGE);
			positions = getNextInt();

			// If the input positions is not an integer exist from the program
			if (positions == NO_MORE_INPUT)
				System.exit(0);

			// Read input array from the console
			System.out.println(ARRAY_MESSAGE);
			System.out.println(ANY_KEY_MESSAGE);
			while (scanner.hasNextInt()) {

				inputArray.add(scanner.nextInt());
			}

			// If the input array is not set exist from the program
			if (inputArray.isEmpty())
				System.exit(0);

			rotate();

			// Print results to the console
			System.out.println(ORIG_ARRAY_MESSAGE);
			System.out.println(inputArray);

			System.out.println(ROTATED_ARRAY_MESSAGE);
			System.out.println(rotatedArray);
		}

		/**
		 * Read the next input from the scanner.
		 *
		 * @return the integer value of the input or NO_MORE_INPUT constant if the input was not an integer
		 */
		private int getNextInt() {

			return scanner.hasNextInt() ? scanner.nextInt() : NO_MORE_INPUT;
		}

		/**
		 * Rotate the input {@link ArrayList} with the number of positions and add new values
		 * to rotatedArray;
		 *
		 * @param positions the number which will be use to rotate array
		 * @param inputArrayList the array which will be rotate
		 */
		public void rotate() {

			rotatedArray.addAll(inputArray);
			Collections.rotate(rotatedArray, positions);
		}

		protected List<Integer> getInputArray() {
			return inputArray;
		}

		protected List<Integer> getRotatedArray() {
			return rotatedArray;
		}

	}
}