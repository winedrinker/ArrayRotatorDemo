package csaba.rotator;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import csaba.rotator.ArrayRotatorDemo.ArrayRotator;


public class ArrayRotatorTest {

	@Rule
	public final TextFromStandardInputStream mockInput = TextFromStandardInputStream.emptyStandardInputStream();

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();

	/**
	 * Test case when the first input is not an integer and the program quit immediately.
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void testRotator_QuitImmediately() throws InterruptedException {

		mockInput.provideText("q"); //$NON-NLS-1$
		exit.expectSystemExitWithStatus(0);
		new ArrayRotator().run();
	}

	/**
	 * Test case when the positions is set, but the input array is not defined by the user, so that is empty.
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void testRotator_NoArray() throws InterruptedException {

		mockInput.provideText("1"); //$NON-NLS-1$
		exit.expectSystemExitWithStatus(0);
		final ArrayRotator rotator = new ArrayRotator();
		rotator.run();

		assertTrue("Input Array should be empty, because that is not typed by the user!", rotator.getInputArray().isEmpty()); //$NON-NLS-1$
		assertTrue("Rotated Array should be empty, because input array was empty!", rotator.getRotatedArray().isEmpty()); //$NON-NLS-1$
	}

	/**
	 * Test case when the positions is set, but the next input is a key which involve the quit.
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void testRotator_SetPositionsAndQuit() throws InterruptedException {

		mockInput.provideText("1 q"); //$NON-NLS-1$
		exit.expectSystemExitWithStatus(0);
		final ArrayRotator rotator = new ArrayRotator();
		rotator.run();

		assertTrue("Input Array should be empty, because quit from the program!", rotator.getInputArray().isEmpty()); //$NON-NLS-1$
		assertTrue("Rotated Array should be empty, because input array was empty!", rotator.getRotatedArray().isEmpty()); //$NON-NLS-1$
	}

	/**
	 * Test case when the positions is a positive integer and the input array also is set.
	 * The positions is 2.
	 * The input array is: [5, 10, 12, 128, 3]
	 * The expected rotated array is: [128, 3, 5, 10, 12]
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void testRotator_PositionPositive() throws InterruptedException {

		mockInput.provideText("2 5 10 12 128 3"); //$NON-NLS-1$
		final ArrayRotator rotator = new ArrayRotator();
		rotator.run();

		final ArrayList<Integer> expectedOriginal = getExpectedOriginalArray();
		final ArrayList<Integer> expectedRotated = new ArrayList<>(Arrays.asList(128, 3, 5, 10, 12));

		assertEquals(expectedOriginal, rotator.getInputArray());
		assertEquals(expectedRotated, rotator.getRotatedArray());
	}

	/**
	 * Test case when the positions is a negative integer and the input array also is set.
	 * The positions is -2.
	 * The input array is: [5, 10, 12, 128, 3]
	 * The expected rotated array is: [12, 128, 3, 5, 10]
	 *
	 * @throws InterruptedException
	 */
	@Test
	public void testRotator_PositionNegative() throws InterruptedException {

		mockInput.provideText("-2 5 10 12 128 3"); //$NON-NLS-1$
		final ArrayRotator rotator = new ArrayRotator();
		rotator.run();

		final ArrayList<Integer> expectedOriginal = getExpectedOriginalArray();
		final ArrayList<Integer> expectedRotated = new ArrayList<>(Arrays.asList(12, 128, 3, 5, 10));

		assertEquals(expectedOriginal, rotator.getInputArray());
		assertEquals(expectedRotated, rotator.getRotatedArray());
	}

	private static ArrayList<Integer> getExpectedOriginalArray() {
		return new ArrayList<>(Arrays.asList(5, 10, 12, 128, 3));
	}
}