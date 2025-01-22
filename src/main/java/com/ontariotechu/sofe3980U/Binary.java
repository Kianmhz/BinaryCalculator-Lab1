package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
	private String number = "0"; // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or
	 *               ones with any length and order. otherwise, the value of "0"
	 *               will be stored. Trailing zeros will be excluded and empty
	 *               string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		// Ensure empty strings are replaced with "0"
		if (this.number.isEmpty()) {
			this.number = "0";
		}
	}

	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary variables. For more information, visit
	 * <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers
	 * </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		// initial variable
		int carry = 0;
		String num3 = ""; // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2; // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
		}
		Binary result = new Binary(num3); // create a binary object with the calculated value.
		return result;

	}

	/**
	 * Performs a bitwise logical OR operation between two binary numbers.
	 *
	 * @param num1 the first binary number
	 * @param num2 the second binary number
	 * @return a new Binary object representing the result of the OR operation
	 */
	public static Binary or(Binary num1, Binary num2) {
		// The index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // The binary value of the result

		// Loop until all digits are processed
		while (ind1 >= 0 || ind2 >= 0) {
			int sum = 0; // Previous carry
			if (ind1 >= 0) { // If num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // Convert the digit to int and add it to sum
				ind1--; // Update ind1
			}
			if (ind2 >= 0) { // If num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // Convert the digit to int and add it to sum
				ind2--; // Update ind2
			}
			num3 = ((sum == 0) ? "0" : "1") + num3; // Convert sum to string and append it to num3
		}

		Binary result = new Binary(num3); // Create a binary object with the calculated value
		return result;
	}

	/**
	 * Performs a bitwise logical AND operation between two binary numbers.
	 *
	 * @param num1 the first binary number
	 * @param num2 the second binary number
	 * @return a new Binary object representing the result of the AND operation
	 */
	public static Binary and(Binary num1, Binary num2) {
		// The index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // The binary value of the result

		// Loop until all digits are processed
		while (ind1 >= 0 && ind2 >= 0) {
			int sum = 0; // Previous carry
			if (ind1 >= 0) { // If num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // Convert the digit to int and add it to sum
				ind1--; // Update ind1
			}
			if (ind2 >= 0) { // If num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // Convert the digit to int and add it to sum
				ind2--; // Update ind2
			}
			num3 = ((sum == 2) ? "1" : "0") + num3; // Convert sum to string and append it to num3
		}

		Binary result = new Binary(num3); // Create a binary object with the calculated value
		return result;
	}

	/**
	 * Multiplies two binary numbers using bitwise addition and shifting.
	 *
	 * @param num1 the first binary number
	 * @param num2 the second binary number
	 * @return a new Binary object representing the result of the multiplication
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		String num1Str = num1.number;
		String num2Str = num2.number;

		String result = "0"; // Initialize result as binary "0"

		// Loop through num1 from right to left
		for (int i = num1Str.length() - 1; i >= 0; i--) {
			if (num1Str.charAt(i) == '1') {
				// Shift num2 by the appropriate number of positions
				String shiftedNum2 = num2Str + "0".repeat(num1Str.length() - 1 - i);

				// Add the shifted value to the result
				result = add(new Binary(result), new Binary(shiftedNum2)).getValue();
			}
		}

		// Return the result as a Binary object
		return new Binary(result);
	}
}